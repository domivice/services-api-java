package org.domivice.services.web.test.api.licences;

import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.LicenceTypeList;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class ListLicenceTypeTests extends AbstractIntegrationTests {
    private static final String SEARCH_TERM = "license";
    private static final int PAGE = 1;
    private static final int PAGE_SIZE = 5;
    private static final String SORT = "name:asc";
    private final String ENDPOINT = "/services/v1/licence-types";

    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository repository;

    @BeforeEach
    void setUp() {
        StepVerifier.create(repository.deleteAll()).verifyComplete();
        seedDatabase(
            LicenceType.create(UUID.randomUUID(), "Business License"),
            LicenceType.create(UUID.randomUUID(), "Driver's License"),
            LicenceType.create(UUID.randomUUID(), "Professional License"),
            LicenceType.create(UUID.randomUUID(), "Marriage License"),
            LicenceType.create(UUID.randomUUID(), "Fishing License"),
            LicenceType.create(UUID.randomUUID(), "Hunting License"),
            LicenceType.create(UUID.randomUUID(), "Building Permit"),
            LicenceType.create(UUID.randomUUID(), "Liquor License"),
            LicenceType.create(UUID.randomUUID(), "Health Permit"),
            LicenceType.create(UUID.randomUUID(), "Pet License"),
            LicenceType.create(UUID.randomUUID(), "Broadcasting License"),
            LicenceType.create(UUID.randomUUID(), "Import/Export License"),
            LicenceType.create(UUID.randomUUID(), "Software License"),
            LicenceType.create(UUID.randomUUID(), "Pilot's License"),
            LicenceType.create(UUID.randomUUID(), "Real Estate License")
        );
    }

    @DisplayName("200Test: Should return a Licence Type List with pagination")
    @Test
    void shouldReturnPaginatedLicenceTypeList() {
        // Verify the first page
        webClient.mutateWith(authorizedJwtMutator)
            .get()
            .uri(uriBuilder -> uriBuilder.path(ENDPOINT)
                .queryParam("search", SEARCH_TERM)
                .queryParam("page", PAGE)
                .queryParam("pageSize", PAGE_SIZE)
                .queryParam("sort", SORT)
                .build())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(LicenceTypeList.class)
            .value(list -> {
                Assertions.assertEquals(PAGE_SIZE, list.getData().size(), "First page should contain 5 items");
                Assertions.assertTrue(list.getData().getFirst().getName().startsWith("B"), "First item should be 'Broadcasting License'");
            });

        // Verify the second page
        webClient.mutateWith(authorizedJwtMutator)
            .get()
            .uri(uriBuilder -> uriBuilder.path(ENDPOINT)
                .queryParam("search", "License")
                .queryParam("page", PAGE + 1)
                .queryParam("pageSize", PAGE_SIZE)
                .queryParam("sort", "name:asc")
                .build())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(LicenceTypeList.class)
            .value(list -> {
                Assertions.assertEquals(PAGE_SIZE, list.getData().size(), "Second page should contain 5 items");
                Assertions.assertNotEquals("Business License", list.getData().getFirst().getName(), "First item of the second page should not be 'Business License'");
            });
    }

    @DisplayName("200Test: Should return an empty Licence Type List")
    @Test
    void shouldReturnAnEmptyLicenceTypeList() {
        // Verify the response from the endpoint
        webClient.mutateWith(authorizedJwtMutator)
            .get()
            .uri(uriBuilder -> uriBuilder.path(ENDPOINT)
                .queryParam("search", UUID.randomUUID().toString())
                .queryParam("page", PAGE)
                .queryParam("pageSize", PAGE_SIZE)
                .queryParam("sort", SORT)
                .build())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(LicenceTypeList.class)
            .value(list -> Assertions.assertTrue(list.getData().isEmpty(), "Licence Type list should be empty"));
    }

    @DisplayName("200Test: Should return a Licence Type List with default pagination parameters")
    @Test
    void shouldReturnPaginatedLicenceTypeListWithDefaultPaginationParameters() {
        webClient.mutateWith(authorizedJwtMutator)
            .get()
            .uri(uriBuilder -> uriBuilder.path(ENDPOINT).build())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(LicenceTypeList.class)
            .value(list -> Assertions.assertTrue(list.getData().getFirst().getName().startsWith("B"), "First item should be 'Broadcasting License'"));
    }

    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        webClient.get()
            .uri(ENDPOINT)
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
            .uri(ENDPOINT)
            .exchange()
            .expectStatus()
            .isForbidden();
    }

    private void seedDatabase(LicenceType... licenceTypes) {
        for (LicenceType licenceType : licenceTypes) {
            StepVerifier.create(repository.insert(licenceType))
                .expectNextCount(1)
                .verifyComplete();
        }
    }
}
