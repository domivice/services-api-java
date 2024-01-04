package org.domivice.services.web.test.api.licences;

import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


class AddLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    @Autowired
    private WebTestClient webClient;

    @Test
    @DisplayName("Should Create Licence Type Success")
    void shouldReturnStatusCreated() {
        webClient
                .post()
                .uri(ENDPOINT)
                .bodyValue(new LicenceTypeCreate().name("New Licence"))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(org.domivice.services.openapi.models.LicenceType.class);
    }

    @DisplayName("Should return Problem Details When Name is Empty")
    @Test
    void shouldReturnProblemDetailWhenNameIsEmpty() {
        LicenceTypeCreate licenceTypeCreate = new LicenceTypeCreate();
        webClient
                .post()
                .uri(ENDPOINT)
                .bodyValue(licenceTypeCreate)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody().jsonPath("$.errors").isNotEmpty();
    }

}
