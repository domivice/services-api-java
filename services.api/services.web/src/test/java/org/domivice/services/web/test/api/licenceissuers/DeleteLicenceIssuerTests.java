package org.domivice.services.web.test.api.licenceissuers;

import org.domivice.services.application.licenceissuers.LicenceIssuerRepository;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.services.LicenceIssuerCommandService;
import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.UUID;

import static org.domivice.services.web.exceptions.GlobalExceptionHandler.NOT_FOUND_PROBLEM_TYPE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class DeleteLicenceIssuerTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-issuers";
    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceIssuerRepository licenceIssuerRepository;
    @Autowired
    private LicenceIssuerCommandService licenceIssuerCommandService;
    @Autowired
    private LicenceTypeRepository licenceTypeRepository;

    @BeforeEach
    void setUp() {
        StepVerifier.create(licenceIssuerRepository.deleteAll()).verifyComplete();
    }
    @DisplayName("200Test: Should delete a licence issuer")
    @Test
    void shouldDeleteALicenceIssuer() {
        var licenceType = LicenceType.create(UUID.randomUUID(), "Licence Type");
        StepVerifier.create(licenceTypeRepository.insert(licenceType))
            .expectNextCount(1).verifyComplete();

        var createCommand = CreateLicenceIssuerCommand.builder()
            .commandId(UUID.randomUUID())
            .aggregateId(UUID.randomUUID())
            .issuerName("New York State Board for Psychology")
            .issuingCountryCode("US")
            .issuingStateCode("NY")
            .licenceTypeId(licenceType.getId())
            .build();

        var addLicenceIssuerMono = licenceIssuerCommandService.addLicenceIssuer(createCommand);
        StepVerifier.create(addLicenceIssuerMono).assertNext(insertedLicenceIssuer -> {
            assertNotNull(insertedLicenceIssuer, "Inserted Licence issuer should not be null");

            webClient.mutateWith(authorizedJwtMutator)
                .delete()
                .uri(ENDPOINT + "/" + insertedLicenceIssuer.getId())
                .exchange()
                .expectStatus()
                .isNoContent()
                .expectBody()
                .consumeWith(response -> {
                    // Step 3: Verify the license type is deleted
                    RepeatedStepVerifier(
                        () -> licenceIssuerRepository.existsById(insertedLicenceIssuer.getId()),
                        10, // Max retries
                        Duration.ofMillis(100) // Delay between retries
                    );
                });
        }).verifyComplete();
    }
    @DisplayName("404Test: Should return status not found")
    @Test
    void shouldReturnStatusNotFound(){
        var licenceIssuerId = UUID.randomUUID();
        webClient.mutateWith(authorizedJwtMutator).delete()
            .uri(ENDPOINT + "/" + licenceIssuerId)
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals(NOT_FOUND_PROBLEM_TYPE, problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("Licence issuer with id " + licenceIssuerId + " not found", problemDetail.getTitle(), "Incorrect problem title");
            });
    }
    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        webClient.delete()
            .uri(ENDPOINT + "/" + UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isUnauthorized();
    }

    @Test
    @DisplayName("403Test: Should return status forbidden for non admin users")
    void shouldReturnStatusForbiddenForNonAdminUsers() {
        webClient.mutateWith(mockJwt()
                .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
                .authorities(new SimpleGrantedAuthority("SCOPE_" + AUDIENCE)))
            .delete()
            .uri(ENDPOINT + "/" + UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isForbidden();
    }
}
