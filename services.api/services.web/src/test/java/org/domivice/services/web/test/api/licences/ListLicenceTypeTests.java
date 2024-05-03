package org.domivice.services.web.test.api.licences;

import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.infrastructure.persistence.mongodb.repositories.LicenceTypeMongoRepository;
import org.domivice.services.openapi.models.LicenceTypeList;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class ListLicenceTypeTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-types";
    private final String AUDIENCE = "services.api";
    private final String ADMIN_ROLE = "AppAdmin";
    private final String TOKEN_TYPE = "at+jwt";
    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeMongoRepository repository;
    private final SecurityMockServerConfigurers.JwtMutator authorizedJwtMutator = mockJwt()
            .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
            .authorities(new SimpleGrantedAuthority("ROLE_" + ADMIN_ROLE), new SimpleGrantedAuthority("SCOPE_" + AUDIENCE));
    @DisplayName("200Test: Should return a Licence Type List")
    @Test
    void shouldReturnALicenceTypeList() {
        var licenceType = LicenceType.create("Licence Type");

        // Insert the licence type and verify the insertion
        StepVerifier.create(repository.insert(licenceType)).expectNextCount(1).verifyComplete();

        // Verify the response from the endpoint
        webClient.mutateWith(authorizedJwtMutator)
                .get()
                .uri(ENDPOINT + "?search=licence")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(LicenceTypeList.class)
                .value(list -> Assertions.assertTrue(list.getData().size() > 1) );
    }

    @DisplayName("200Test: Should return an empty Licence Type List")
    @Test
    void shouldReturnAnEmptyLicenceTypeList() {
        var licenceType = LicenceType.create("Licence Type");

        // Insert the licence type and verify the insertion
        StepVerifier.create(repository.insert(licenceType)).expectNextCount(1).verifyComplete();

        // Verify the response from the endpoint
        webClient.mutateWith(authorizedJwtMutator)
                .get()
                .uri(ENDPOINT + "?search=" + UUID.randomUUID())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(LicenceTypeList.class)
                .value(list -> Assertions.assertTrue(list.getData().isEmpty()) );
    }
}
