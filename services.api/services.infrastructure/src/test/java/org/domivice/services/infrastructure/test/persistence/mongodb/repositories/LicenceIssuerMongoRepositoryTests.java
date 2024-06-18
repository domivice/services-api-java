package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.services.domain.entities.LicenceIssuer;
import org.domivice.services.infrastructure.persistence.mongodb.repositories.LicenceIssuerMongoRepository;
import org.domivice.services.infrastructure.test.persistence.mongodb.MongoInfra;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.regex.Pattern;

@SpringBootTest(classes = LicenceIssuerMongoRepository.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LicenceIssuerMongoRepositoryTests extends MongoInfra {
    @Autowired
    private LicenceIssuerMongoRepository repository;

    @BeforeAll
    void setUp() {
        StepVerifier.create(repository.deleteAll()).verifyComplete();
    }

    @Test
    @DisplayName("Repository Should Insert Licence Issuer Success")
    void repositoryShouldInsertLicenceTypeSuccess() {
        //Given
        var licenceIssuer = LicenceIssuer.create(
            "Société de l'assurance automobile du Québec",
            "CA",
            "QC",
            UUID.randomUUID()
        );

        // Act & Assert
        StepVerifier.create(repository.insert(licenceIssuer))
            .expectNextMatches(insertedLicenceIssuer -> {
                Assertions.assertNotNull(insertedLicenceIssuer);
                return insertedLicenceIssuer.getId().equals(licenceIssuer.getId());
            })
            .verifyComplete();
    }

    @Test
    @DisplayName("Repository should find one licence issuer")
    void repositoryShouldFindOneLicenceIssuerSuccess() {
        // Given
        var licenceIssuer = LicenceIssuer.create(
            "Régie du bâtiment du Québec",
            "CA",
            "QC",
            UUID.randomUUID()
        );
        seedDatabase(licenceIssuer);

        // Act & Assert
        StepVerifier.create(repository.findOneById(licenceIssuer.getId()))
            .expectNextMatches(retrievedLicenceIssuer -> {
                Assertions.assertNotNull(retrievedLicenceIssuer);
                return retrievedLicenceIssuer.getId().equals(licenceIssuer.getId());
            })
            .verifyComplete();
    }

    @Test
    @DisplayName("Repository should find issuer name like success")
    void repositoryShouldSearchByIssuerNameSuccess() {
        // Given
        seedDatabase(
            LicenceIssuer.create("Régie du bâtiment du Québec", "CA", "QC", UUID.randomUUID()),
            LicenceIssuer.create("Société de l'assurance automobile du Québec", "CA", "QC", UUID.randomUUID()),
            LicenceIssuer.create("Collège des médecins du Québec", "CA", "QC", UUID.randomUUID())
        );

        // Act & Assert
        var searchTerm = "quebec";
        String regex = "(?i).*" + Pattern.quote(removeDiacritics(searchTerm)) + ".*";
        Flux<LicenceIssuer> licenceIssuerFlux = repository.searchByIssuerName(searchTerm, Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenceIssuerFlux.collectList())
            .expectNextMatches(licenceIssuerList -> {
                Assertions.assertNotNull(licenceIssuerList, "List should not be null");
                return licenceIssuerList.stream().allMatch(
                    licenceIssuer -> Pattern.matches(regex, removeDiacritics(licenceIssuer.getIssuerName()))
                );
            }).verifyComplete();
    }

    @Test
    @DisplayName("Repository should find by issuing country code")
    void repositoryShouldFindByIssuingCountryCodeSuccess() {
        // Given
        seedDatabase(
            // US Licenses
            LicenceIssuer.create("Driver's License", "US", "CA", UUID.randomUUID()),
            LicenceIssuer.create("Medical License", "US", "NY", UUID.randomUUID()),
            LicenceIssuer.create("California Board of Psychology", "US", "CA", UUID.randomUUID()),
            // Canada Licenses
            LicenceIssuer.create("Driver's Licence", "CA", "ON", UUID.randomUUID()),
            LicenceIssuer.create("Medical Licence", "CA", "QC", UUID.randomUUID()),
            LicenceIssuer.create("College of Psychologists of Ontario", "CA", "ON", UUID.randomUUID())
        );

        // Act
        Flux<LicenceIssuer> licenceIssuerFlux = repository.findByIssuingCountryCode("US", Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenceIssuerFlux.collectList())
            .expectNextMatches(licenceIssuerList -> {
                Assertions.assertNotNull(licenceIssuerList, "List should not be null");
                return licenceIssuerList.stream().allMatch(
                    licenceIssuer -> "US".equals(licenceIssuer.getIssuingCountryCode())
                );
            }).verifyComplete();

    }

    @Test
    @DisplayName("Repository should find by issuing state code")
    void repositoryShouldFindByIssuingStateCodeSuccess() {
        // Given
        seedDatabase(
            // Licenses from California (CA)
            LicenceIssuer.create("Driver's License", "US", "CA", UUID.randomUUID()),
            LicenceIssuer.create("Medical License", "US", "CA", UUID.randomUUID()),
            LicenceIssuer.create("California Board of Psychology", "US", "CA", UUID.randomUUID()),
            // Licenses from New York (NY)
            LicenceIssuer.create("Driver's License", "US", "NY", UUID.randomUUID()),
            LicenceIssuer.create("Medical License", "US", "NY", UUID.randomUUID()),
            LicenceIssuer.create("New York State Board for Psychology", "US", "NY", UUID.randomUUID())
        );

        //Act
        Flux<LicenceIssuer> licenceIssuerFlux = repository.findByIssuingStateCode("NY", Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenceIssuerFlux.collectList())
            .expectNextMatches(licenceIssuerList -> {
                Assertions.assertNotNull(licenceIssuerList, "List should not be null");
                return licenceIssuerList.stream().allMatch(
                    licenceIssuer -> "NY".equals(licenceIssuer.getIssuingStateCode())
                );
            }).verifyComplete();
    }

    private void seedDatabase(LicenceIssuer... licenceIssuers) {
        for (LicenceIssuer licenceIssuer : licenceIssuers) {
            StepVerifier.create(repository.insert(licenceIssuer)).expectNextCount(1).verifyComplete();
        }
    }
}
