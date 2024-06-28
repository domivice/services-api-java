package org.domivice.services.web.test.api.licencetypes;

import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.application.licencetypes.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licencetypes.services.LicenceTypeCommandService;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.UUID;

import static org.domivice.services.web.exceptions.GlobalExceptionHandler.NOT_FOUND_PROBLEM_TYPE;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeleteLicenceTypeTests extends AbstractIntegrationTests {
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

    @DisplayName("200Test: Should delete a licence type")
    @Test
    void shouldDeleteALicenceType() {
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

            // Step 2: Delete the inserted license type using webClient
            webClient.mutateWith(authorizedJwtMutator)
                .delete()
                .uri(ENDPOINT + "/" + insertedLicenceType.getId())
                .exchange()
                .expectStatus()
                .isNoContent()
                .expectBody()
                .consumeWith(response -> {
                    // Step 3: Verify the license type is deleted
                    RepeatedStepVerifier(
                        () -> repository.existsById(insertedLicenceType.getId()),
                        10, // Max retries
                        Duration.ofMillis(100) // Delay between retries
                    );
                });
        }).verifyComplete();
    }

    @DisplayName("404Test: Should return status not found")
    @Test
    void shouldReturnStatusNotFound() {
        var licenceTypeId = UUID.randomUUID();
        webClient.mutateWith(authorizedJwtMutator).delete()
            .uri(ENDPOINT + "/" + licenceTypeId)
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals(NOT_FOUND_PROBLEM_TYPE, problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("Licence type with id " + licenceTypeId + " not found", problemDetail.getTitle(), "Incorrect problem title");
            });
    }
}
