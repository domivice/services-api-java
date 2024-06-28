package org.domivice.services.web.test.api.licenceissuers;

import org.domivice.services.application.licencetypes.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.LicenceIssuer;
import org.domivice.services.openapi.models.LicenceIssuerCreate;
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
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.stream.Stream;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class AddLicenceIssuerTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-issuers";

    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository licenceTypeRepository;

    private static Stream<LicenceIssuerCreate> invalidLicenceIssuerPayloads() {
        return Stream.of(
            new LicenceIssuerCreate(),//missing name
            new LicenceIssuerCreate().issuerName("&#%@%@"),//invalid name
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology"), //missing country
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology").issuingCountryCode("XX"), //invalid country
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology").issuingCountryCode("US"), //missing state
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology").issuingCountryCode("US").issuingStateCode("XX"), //invalid state
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology").issuingCountryCode("US").issuingStateCode("NY"), //missing licence type id
            new LicenceIssuerCreate().issuerName("New York State Board for Psychology").issuingCountryCode("US").issuingStateCode("NY").licenceTypeId(UUID.randomUUID()) //invalid licence type id
        );
    }

    @Test
    @DisplayName("201Test: Should Create Licence Issuer Success")
    void shouldReturnStatusCreated() {
        var licenceType = LicenceType.create(UUID.randomUUID(), "Licence Type");
        // Insert the licence type and verify the insertion
        StepVerifier.create(licenceTypeRepository.insert(licenceType))
            .expectNextCount(1).verifyComplete();

        LicenceIssuerCreate licenceIssuerCreate = new LicenceIssuerCreate();
        licenceIssuerCreate.setIssuerName("New York State Board for Psychology");
        licenceIssuerCreate.setIssuingCountryCode("US");
        licenceIssuerCreate.setIssuingStateCode("NY");
        licenceIssuerCreate.setLicenceTypeId(licenceType.getId());

        webClient
            .mutateWith(authorizedJwtMutator)
            .post()
            .uri(ENDPOINT)
            .bodyValue(licenceIssuerCreate)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(LicenceIssuer.class);
    }

    @Test
    @DisplayName("401Test: Should return status unauthorized for non authenticated users")
    void shouldReturnStatusUnAuthorizedForNonAuthenticatedUsers() {
        LicenceIssuerCreate licenceIssuerCreate = new LicenceIssuerCreate();
        licenceIssuerCreate.setIssuerName("New York State Board for Psychology");
        licenceIssuerCreate.setIssuingCountryCode("US");
        licenceIssuerCreate.setIssuingStateCode("NY");
        licenceIssuerCreate.setLicenceTypeId(UUID.randomUUID());

        webClient
            .post()
            .uri(ENDPOINT)
            .bodyValue(licenceIssuerCreate)
            .exchange()
            .expectStatus()
            .isUnauthorized();
    }

    @Test
    @DisplayName("403Test: Should return status forbidden for non admin users")
    void shouldReturnStatusForbiddenForNonAdminUsers() {
        LicenceIssuerCreate licenceIssuerCreate = new LicenceIssuerCreate();
        licenceIssuerCreate.setIssuerName("New York State Board for Psychology");
        licenceIssuerCreate.setIssuingCountryCode("US");
        licenceIssuerCreate.setIssuingStateCode("NY");
        licenceIssuerCreate.setLicenceTypeId(UUID.randomUUID());

        webClient
            .mutateWith(mockJwt()
                .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
                .authorities(new SimpleGrantedAuthority("SCOPE_" + AUDIENCE)))
            .post()
            .uri(ENDPOINT)
            .bodyValue(licenceIssuerCreate)
            .exchange()
            .expectStatus()
            .isForbidden();
    }

    @DisplayName("400Test: Should produce validation errors for invalid inputs")
    @ParameterizedTest(name = "round {index} => payload={0}")
    @MethodSource("invalidLicenceIssuerPayloads")
    void shouldProduceValidationErrorsForInvalidInputs(LicenceIssuerCreate payload) {
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
