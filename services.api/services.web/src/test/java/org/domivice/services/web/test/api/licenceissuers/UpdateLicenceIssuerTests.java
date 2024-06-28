package org.domivice.services.web.test.api.licenceissuers;

import org.domivice.services.application.licenceissuers.LicenceIssuerRepository;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.services.LicenceIssuerCommandService;
import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.LicenceIssuerPatch;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class UpdateLicenceIssuerTests extends AbstractIntegrationTests {
    private static LicenceIssuer validLicenceIssuer;
    private final String ENDPOINT = "/services/v1/licence-issuers";
    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository licenceTypeRepository;
    @Autowired
    private LicenceIssuerRepository licenceIssuerRepository;
    @Autowired
    private LicenceIssuerCommandService licenceIssuerCommandService;

    @BeforeAll
    static void setUp(@Autowired LicenceTypeRepository licenceTypeRepository,
                      @Autowired LicenceIssuerCommandService licenceIssuerCommandService) {
        // Create and insert a valid licence type
        var licenceType = LicenceType.create(UUID.randomUUID(), "Licence Type");
        StepVerifier.create(licenceTypeRepository.insert(licenceType))
            .expectNextCount(1).verifyComplete();

        // Create and insert a valid licence issuer
        var createCommand = CreateLicenceIssuerCommand.builder()
            .issuerName("New York State Board for Psychology")
            .issuingStateCode("NY")
            .issuingCountryCode("US")
            .licenceTypeId(licenceType.getId())
            .aggregateId(UUID.randomUUID())
            .build();

        var licenceIssuerMono = licenceIssuerCommandService.addLicenceIssuer(createCommand);
        StepVerifier.create(licenceIssuerMono)
            .assertNext(licenceIssuer -> validLicenceIssuer = licenceIssuer)
            .verifyComplete();
    }

    private static Stream<LicenceIssuerPatch> invalidLicenceIssuerPatches() {
        return Stream.of(
            new LicenceIssuerPatch().id(UUID.randomUUID()).issuerName("%%%()*)##"),  // Invalid name
            new LicenceIssuerPatch().id(UUID.randomUUID()).issuingCountryCode("US").issuingStateCode("ON"),  // Invalid country/state code combination
            new LicenceIssuerPatch().id(UUID.randomUUID()).issuingCountryCode("XX"),  // Invalid country code
            new LicenceIssuerPatch().id(UUID.randomUUID()).licenceTypeId(UUID.randomUUID())  // Invalid licence type ID
        );
    }

    @DisplayName("200Test: Should update a licence issuer")
    @Test
    void shouldUpdateALicenceIssuer() {
        assertNotNull(validLicenceIssuer, "Inserted Licence Issuer should not be null");

        // Step 2: Update the inserted license issuer using webClient
        var updatedName = "updated name";
        webClient.mutateWith(authorizedJwtMutator)
            .patch()
            .uri(ENDPOINT + "/" + validLicenceIssuer.getId())
            .bodyValue(new LicenceIssuerPatch()
                .id(UUID.randomUUID())
                .issuerName(updatedName)
            )
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(response -> {
                // Step 3: Verify the license issuer is updated
                StepVerifier.create(licenceIssuerRepository.findOneById(validLicenceIssuer.getId()))
                    .expectNextMatches(retrievedLicenceIssuer -> retrievedLicenceIssuer.getIssuerName().equals(updatedName))
                    .verifyComplete();
            });
    }

    @DisplayName("400Test: Should produce validation errors for invalid inputs")
    @ParameterizedTest(name = "round {index} => patch={0}")
    @MethodSource("invalidLicenceIssuerPatches")
    void shouldProduceValidationErrorsForInvalidInputs(LicenceIssuerPatch patch) {
        assertNotNull(validLicenceIssuer, "Valid Licence Issuer should not be null");

        webClient.mutateWith(authorizedJwtMutator)
            .patch()
            .uri(ENDPOINT + "/" + validLicenceIssuer.getId())
            .bodyValue(patch)
            .exchange()
            .expectStatus()
            .isBadRequest();
    }

    @DisplayName("404Test: Should return status not found")
    @Test
    void shouldReturnStatusNotFound() {
        var licenceIssuerId = UUID.randomUUID();
        webClient.mutateWith(authorizedJwtMutator)
            .patch()
            .uri(ENDPOINT + "/" + licenceIssuerId)
            .bodyValue(new LicenceIssuerPatch()
                .id(UUID.randomUUID())
                .issuerName("updated name"))
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/not-found", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("Licence issuer with id " + licenceIssuerId + " not found", problemDetail.getTitle(), "Incorrect problem title");
            });
    }

    @Test
    @DisplayName("403Test: Should return status forbidden for non admin users")
    void shouldReturnStatusForbiddenForNonAdminUsers() {
        webClient
            .mutateWith(mockJwt()
                .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
                .authorities(new SimpleGrantedAuthority("SCOPE_" + AUDIENCE)))
            .patch()
            .uri(ENDPOINT + "/" + UUID.randomUUID())
            .bodyValue(new LicenceIssuerPatch()
                .id(UUID.randomUUID())
                .issuerName("updated name"))
            .exchange()
            .expectStatus()
            .isForbidden();
    }

    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        webClient
            .patch()
            .uri(ENDPOINT + "/" + UUID.randomUUID())
            .bodyValue(new LicenceIssuerPatch()
                .id(UUID.randomUUID())
                .issuerName("updated name"))
            .exchange()
            .expectStatus()
            .isUnauthorized();
    }
}
