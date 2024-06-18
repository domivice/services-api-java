package org.domivice.services.web.test.api.licences;

import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.openapi.models.LicenceIssuer;
import org.domivice.services.openapi.models.LicenceIssuerCreate;
import org.domivice.services.openapi.models.ProblemDetail;
import org.domivice.services.web.AbstractIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

class AddLicenceIssuerTests extends AbstractIntegrationTests {
    private final String ENDPOINT = "/services/v1/licence-issuers";
    private final String AUDIENCE = "services.api";
    private final String ADMIN_ROLE = "AppAdmin";
    private final String TOKEN_TYPE = "at+jwt";
    private final SecurityMockServerConfigurers.JwtMutator authorizedJwtMutator = mockJwt()
        .jwt(jwt -> jwt.header("typ", TOKEN_TYPE))
        .authorities(new SimpleGrantedAuthority("ROLE_" + ADMIN_ROLE), new SimpleGrantedAuthority("SCOPE_" + AUDIENCE));
    @Autowired
    private WebTestClient webClient;
    @Autowired
    private LicenceTypeRepository licenceTypeRepository;

    @Test
    @DisplayName("201Test: Should Create Licence Issuer Success")
    void shouldReturnStatusCreated() {
        var licenceType = LicenceType.create("Licence Type");
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
    @DisplayName("400Test: Should return Problem Details When Licence Type Id is invalid")
    void shouldReturnProblemDetailWhenLicenceTypeIdIsInvalid() {
        LicenceIssuerCreate licenceIssuerCreate = new LicenceIssuerCreate();
        licenceIssuerCreate.setIssuerName("New York State Board for Psychology");
        licenceIssuerCreate.setIssuingCountryCode("US");
        licenceIssuerCreate.setIssuingStateCode("NY");
        licenceIssuerCreate.setLicenceTypeId(UUID.randomUUID());

        webClient.mutateWith(authorizedJwtMutator)
            .post()
            .uri(ENDPOINT)
            .bodyValue(licenceIssuerCreate)
            .exchange()
            .expectStatus().isBadRequest()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/validation-error", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("A validation error occurred", problemDetail.getTitle(), "Incorrect problem title");
                Assertions.assertEquals("One or more fields are invalid", problemDetail.getDetail(), "Incorrect problem detail");
                Assertions.assertTrue(problemDetail.getErrors().containsKey("licenceTypeId"), "licenceTypeId key missing from errors");
            });
    }

    @DisplayName("400Test: Should return Problem Details When Issuer Name is Empty")
    @Test
    void shouldReturnProblemDetailWhenIssuerNameIsEmpty() {
        LicenceIssuerCreate licenceIssuerCreate = new LicenceIssuerCreate();
        licenceIssuerCreate.setIssuingCountryCode("Country Code");
        licenceIssuerCreate.setIssuingStateCode("State Code");
        licenceIssuerCreate.setLicenceTypeId(UUID.randomUUID());

        webClient.mutateWith(authorizedJwtMutator)
            .post()
            .uri(ENDPOINT)
            .bodyValue(licenceIssuerCreate)
            .exchange()
            .expectStatus().isBadRequest()
            .expectBody(ProblemDetail.class)
            .value(problemDetail -> {
                Assertions.assertNotNull(problemDetail);
                Assertions.assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), problemDetail.getStatus(), "Incorrect status code");
                Assertions.assertEquals("https://domivice.com/services/probs/validation-error", problemDetail.getType(), "Incorrect problem type");
                Assertions.assertEquals("A validation error occurred", problemDetail.getTitle(), "Incorrect problem title");
                Assertions.assertEquals("One or more fields are invalid", problemDetail.getDetail(), "Incorrect problem detail");
                Assertions.assertTrue(problemDetail.getErrors().containsKey("issuerName"), "issuerName key missing from errors");
            });
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
}
