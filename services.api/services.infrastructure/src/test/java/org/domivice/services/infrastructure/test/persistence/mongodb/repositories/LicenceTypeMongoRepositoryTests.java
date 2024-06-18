package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.infrastructure.persistence.mongodb.repositories.LicenceTypeMongoRepository;
import org.domivice.services.infrastructure.test.persistence.mongodb.MongoInfra;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.regex.Pattern;

@SpringBootTest(classes = LicenceTypeMongoRepository.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LicenceTypeMongoRepositoryTests extends MongoInfra {
    @Autowired
    private LicenceTypeMongoRepository repository;

    @BeforeAll
    void setUp() {
        StepVerifier.create(repository.deleteAll()).verifyComplete();
    }

    @Test
    @DisplayName("Repository Should Insert Licence Type Success")
    void repositoryShouldInsertLicenceTypeSuccess() {
        //Given
        var licenceType = LicenceType.create("Licence Type");

        // Act & Assert
        StepVerifier.create(repository.insert(licenceType))
            .assertNext(insertedLicenceType -> {
                Assertions.assertNotNull(insertedLicenceType);
                Assertions.assertEquals(licenceType.getId(), insertedLicenceType.getId());
            })
            .verifyComplete();
    }

    @Test
    @DisplayName("Repository Should Find One Licence Type Success")
    void repositoryShouldFindOneLicenceTypeSuccess() {
        // Given
        var licenceType = LicenceType.create("Licence Type");
        seedDatabase(licenceType);

        // Act & Assert
        StepVerifier.create(repository.findOneById(licenceType.getId()))
            .assertNext(retrievedLicenceType -> {
                Assertions.assertNotNull(retrievedLicenceType);
                Assertions.assertEquals(licenceType.getId(), retrievedLicenceType.getId());
            })
            .verifyComplete();
    }

    @Test
    @DisplayName("Repository Should Search Licence Types by name")
    void repositoryShouldSearchByLicenceTypeNameSuccess() {
        // Given
        seedDatabase(
            LicenceType.create("Business License"),
            LicenceType.create("Driver's License"),
            LicenceType.create("Professional License"),
            LicenceType.create("Marriage License"),
            LicenceType.create("Fishing License")
        );

        // Act
        var searchTerm = "license";
        String regex = "(?i).*" + Pattern.quote(removeDiacritics(searchTerm)) + ".*";
        Flux<LicenceType> licenseTypesFlux = repository.searchByLicenceType(searchTerm, Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenseTypesFlux.collectList())
            .expectNextMatches(licenceTypeList -> {
                Assertions.assertNotNull(licenceTypeList, "List should not be null");
                return licenceTypeList.stream().allMatch(
                    licenceType -> Pattern.matches(regex, removeDiacritics(licenceType.getName()))
                );
            }).verifyComplete();
    }

    @Test
    @DisplayName("Repository should return all licence types")
    void repositoryShouldReturnAllLicenceTypes() {
        // Given
        seedDatabase(
            LicenceType.create("Business License"),
            LicenceType.create("Driver's License"),
            LicenceType.create("Professional License"),
            LicenceType.create("Marriage License"),
            LicenceType.create("Fishing License")
        );

        // Act
        Flux<LicenceType> licenseTypesFlux = repository.findBy(Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenseTypesFlux.collectList())
            .expectNextMatches(licenseTypeList -> {
                Assertions.assertNotNull(licenseTypeList, "Find by method should return license types");
                return licenseTypeList.size() >= 5;
            })
            .verifyComplete();
    }

    @Test
    @DisplayName("Repository should return an empty list")
    void repositoryShouldReturnEmptyList() {
        //Given
        seedDatabase(
            LicenceType.create("Business License")
        );

        // Act
        var searchTerm = "non existent licence type";
        Flux<LicenceType> licenseTypesFlux = repository.searchByLicenceType(searchTerm, Pageable.ofSize(10));

        // Assert
        StepVerifier.create(licenseTypesFlux.collectList())
            .expectNextMatches(licenseTypeList -> {
                Assertions.assertNotNull(licenseTypeList, "Find by method should return license types");
                return licenseTypeList.isEmpty();
            })
            .verifyComplete();
    }

    private void seedDatabase(LicenceType... licenceTypes) {
        for (LicenceType licenceType : licenceTypes) {
            StepVerifier.create(repository.insert(licenceType))
                .expectNextCount(1)
                .verifyComplete();
        }
    }
}
