package org.domivice.services.web.test.api.licencetypes;

import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.services.LicenceTypeCommandService;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.LicenceIssuerPatch;
import org.domivice.services.openapi.models.LicenceTypePatch;
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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.domivice.services.web.exceptions.GlobalExceptionHandler.VALIDATION_ERROR_PROBLEM_TYPE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class UpdateLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";

    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository repository;
    @Autowired
    private LicenceTypeCommandService licenceTypeCommandService;

    @BeforeEach
    void setUp() {
        StepVerifier.create(repository.deleteAll()).verifyComplete();
    }

    @DisplayName("200Test: Should update a licence type")
    @Test
    void shouldUpdateALicenceType() {
        // Step 1: Create and add a new license type command
        CreateLicenceTypeCommand createCommand = CreateLicenceTypeCommand.builder()
            .commandId(UUID.randomUUID())
            .aggregateId(UUID.randomUUID())
            .name("Licence Type")
            .build();

        Mono<LicenceType> addLicenceTypeMono = licenceTypeCommandService.addLicenceType(createCommand);

        StepVerifier.create(addLicenceTypeMono).assertNext(insertedLicenceType -> {
            assertNotNull(insertedLicenceType, "Inserted Licence Type should not be null");
            assertNotNull(insertedLicenceType.getId(), "Inserted Licence Type ID should not be null");

            // Step 2: Update the inserted license type using webClient
            var updatedName = "updated name";
            webClient.mutateWith(authorizedJwtMutator)
                .patch()
                .uri(ENDPOINT + "/" + insertedLicenceType.getId())
                .bodyValue(new LicenceTypePatch().id(UUID.randomUUID()).name(updatedName))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(response -> {
                    // Step 3: Verify the license type is updated
                    StepVerifier.create(repository.findOneById(insertedLicenceType.getId()))
                        .expectNextMatches(licenceType -> licenceType.getName().equals(updatedName))
                        .verifyComplete();
                });
        }).verifyComplete();
    }

    @DisplayName("400Test: Should return status bad request")
    @Test
    void shouldReturnStatusBadRequest() {
        var licenceTypeId = UUID.randomUUID();
        webClient.mutateWith(authorizedJwtMutator)
            .patch()
            .uri(ENDPOINT + "/" + licenceTypeId)
            .bodyValue(new LicenceTypePatch().id(UUID.randomUUID()).name("&#*#^@*$&")) // invalid name
            .exchange()
            .expectStatus()
            .isBadRequest()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals(VALIDATION_ERROR_PROBLEM_TYPE, problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("A validation error occurred", problemDetail.getTitle(), "Incorrect problem title");
            });
    }

    @DisplayName("404Test: Should return status not found")
    @Test
    void shouldReturnStatusNotFound() {
        var licenceTypeId = UUID.randomUUID();
        webClient.mutateWith(authorizedJwtMutator)
            .patch()
            .uri(ENDPOINT + "/" + licenceTypeId)
            .bodyValue(new LicenceTypePatch().id(UUID.randomUUID()).name("updated name"))
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/not-found", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("Licence type with id " + licenceTypeId + " not found", problemDetail.getTitle(), "Incorrect problem title");
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
            .bodyValue(new LicenceTypePatch().id(UUID.randomUUID()).name("updated name"))
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
            .bodyValue(new LicenceTypePatch().id(UUID.randomUUID()).name("updated name"))
            .exchange()
            .expectStatus()
            .isUnauthorized();
    }
}
