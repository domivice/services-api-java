package org.domivice.services.web.test.api.licences;

import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class GetLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";

    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository licenceTypeRepository;

    @DisplayName("200Test: Should return a Licence Type")
    @Test
    void shouldReturnALicenceType() {
        var licenceType = LicenceType.create(UUID.randomUUID(), "Licence Type");

        // Insert the licence type and verify the insertion
        StepVerifier.create(licenceTypeRepository.insert(licenceType)).expectNextCount(1).verifyComplete();

        // Verify the response from the endpoint
        webClient.mutateWith(authorizedJwtMutator)
            .get()
            .uri(ENDPOINT + "/" + licenceType.getId())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(LicenceType.class)
            .value(licence -> Assertions.assertEquals(licence.getId(), licenceType.getId()));
    }

    @DisplayName("404Test: Should return status not found")
    @Test
    void shouldReturnStatusNotFound() {
        webClient.mutateWith(authorizedJwtMutator).get()
            .uri(ENDPOINT + "/" + UUID.randomUUID())
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/not-found", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("Licence type not found", problemDetail.getTitle(), "Incorrect problem title");
            });
    }

    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        webClient.get()
            .uri(ENDPOINT + "/d8ad8b7c-685b-4da1-ad73-de1f42736e85")
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
            .get()
            .uri(ENDPOINT + "/d8ad8b7c-685b-4da1-ad73-de1f42736e85")
            .exchange()
            .expectStatus()
            .isForbidden();
    }

}
