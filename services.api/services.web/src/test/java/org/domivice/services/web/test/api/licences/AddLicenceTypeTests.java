package org.domivice.services.web.test.api.licences;

import org.domivice.services.openapi.controllers.LicencesApiController;
import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(LicencesApiController.class)
public class AddLicenceTypeTests {
    @Autowired
    private WebTestClient webClient;
    private final String ENDPOINT = "/services/v1/licence-types";

    @Test
    public void shouldReturnProblemDetailWhenNameIsEmpty() {
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
