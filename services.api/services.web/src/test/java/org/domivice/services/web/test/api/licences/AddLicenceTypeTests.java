package org.domivice.services.web.test.api.licences;

import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;


class AddLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    private final String AUDIENCE = "services.api";
    private final String ADMIN_ROLE = "AppAdmin";
    private final String TOKEN_TYPE = "at+jwt";
    @Autowired
    private WebTestClient webClient;
    private final SecurityMockServerConfigurers.JwtMutator authorizedJwtMutator = mockJwt()
            .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
            .authorities(new SimpleGrantedAuthority("ROLE_" + ADMIN_ROLE), new SimpleGrantedAuthority("SCOPE_" + AUDIENCE));

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
                .expectBody(ProblemDetail.class)
                .consumeWith(response -> Assertions.assertTrue(Objects.requireNonNull(response.getResponseBody()).getErrors().containsKey("name")));
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

    @Test
    @DisplayName("403Test: Should return status forbidden for non admin users")
    void shouldReturnStatusForbiddenForNonAdminUsers() {
        webClient
                .mutateWith(mockJwt()
                        .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
                        .authorities(new SimpleGrantedAuthority("SCOPE_" + AUDIENCE)))
                .post()
                .uri(ENDPOINT)
                .bodyValue(new LicenceTypeCreate().name("New Licence"))
                .exchange()
                .expectStatus()
                .isForbidden();
    }

}
