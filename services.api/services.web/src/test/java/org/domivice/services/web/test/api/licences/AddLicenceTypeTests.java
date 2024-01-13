package org.domivice.services.web.test.api.licences;

import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;


class AddLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    @Autowired
    private WebTestClient webClient;
    private final SecurityMockServerConfigurers.JwtMutator authorizedJwtMutator = mockJwt().jwt(
            jwt -> jwt
                    .header("typ", "at+jwt")
                    .claim("scope", "services.api")
    );

    @Test
    @DisplayName("200Test: Should Create Licence Type Success")
    void shouldReturnStatusCreated() {
        webClient
                .mutateWith(authorizedJwtMutator)
                .post()
                .uri(ENDPOINT)
                .bodyValue(new LicenceTypeCreate().name("New Licence"))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(org.domivice.services.openapi.models.LicenceType.class);
    }

    @DisplayName("400Test: Should return Problem Details When Name is Empty")
    @Test
    void shouldReturnProblemDetailWhenNameIsEmpty() {
        LicenceTypeCreate licenceTypeCreate = new LicenceTypeCreate();
        webClient
                .mutateWith(authorizedJwtMutator)
                .post()
                .uri(ENDPOINT)
                .bodyValue(licenceTypeCreate)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody().jsonPath("$.errors").isNotEmpty();
    }

    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        webClient
                .post()
                .uri(ENDPOINT)
                .bodyValue(new LicenceTypeCreate().name("New Licence"))
                .exchange()
                .expectStatus()
                .isUnauthorized();
    }

}
