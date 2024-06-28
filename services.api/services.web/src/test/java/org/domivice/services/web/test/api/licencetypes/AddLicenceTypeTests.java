package org.domivice.services.web.test.api.licencetypes;

import org.domivice.services.openapi.models.LicenceTypeCreate;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.stream.Stream;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;


class AddLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    @Autowired
    private WebTestClient webClient;

    private static Stream<LicenceTypeCreate> invalidLicenceTypeCreatePayload() {
        return Stream.of(
            new LicenceTypeCreate(), //missing name
            new LicenceTypeCreate().name("#$&#&#&##^") //invalid name
        );
    }

    @Test
    @DisplayName("201Test: Should Create Licence Type Success")
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

    @DisplayName("400Test: Should produce validation errors for invalid inputs")
    @ParameterizedTest(name = "round {index} => patch={0}")
    @MethodSource("invalidLicenceTypeCreatePayload")
    void shouldProduceValidationErrorsForInvalidInputs(LicenceTypeCreate payload) {
        webClient.mutateWith(authorizedJwtMutator)
            .post()
            .uri(ENDPOINT)
            .bodyValue(payload)
            .exchange()
            .expectStatus().isBadRequest()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/validation-error", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("A validation error occurred", problemDetail.getTitle(), "Incorrect problem title");
                Assertions.assertEquals("One or more fields are invalid", problemDetail.getDetail(), "Incorrect problem detail");
            });
    }

}
