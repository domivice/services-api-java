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

import java.util.List;

@SpringBootTest(classes = LicenceTypeMongoRepository.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LicenceTypeMongoRepositoryTests extends MongoInfra {
    @Autowired
    private LicenceTypeMongoRepository repository;

    @BeforeAll
    void setUp() {
        repository.deleteAll().block();
    }

    @Test
    @DisplayName("Repository Should Insert Licence Type Success")
    void repositoryShouldInsertLicenceTypeSuccess() {
        //Given
        var licenceType = LicenceType.create("Licence Type");

        //Act
        var insertedLicenceType = repository.insert(licenceType).block();

        //Assert
        Assertions.assertNotNull(insertedLicenceType);
        Assertions.assertEquals(licenceType.getId(), insertedLicenceType.getId());
    }

    @Test
    @DisplayName("Repository Should Find One Licence Type Success")
    void repositoryShouldFindOneLicenceTypeSuccess() {
        // Given
        var licenceType = LicenceType.create("Licence Type");
        seedDatabase(licenceType);

        // Act
        var retrievedLicenceType = repository.findOneById(licenceType.getId()).block();

        //Assert
        Assertions.assertNotNull(retrievedLicenceType);
        Assertions.assertEquals(licenceType.getId(), retrievedLicenceType.getId());
    }

    @Test
    @DisplayName("Repository Should Search Licence Types by name")
    void repositoryShouldFindByNameLikeSuccess() {
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
        Flux<LicenceType> licenseTypesFlux = repository.findByNameLikeIgnoreCase(searchTerm, Pageable.ofSize(10));

        // Assert
        List<LicenceType> licenseTypes = licenseTypesFlux.collectList().block();
        Assertions.assertNotNull(licenseTypes, "Found LicenceType should not be null");
        Assertions.assertTrue(licenseTypes.size() >= 5, "There should be a least 5 licence types");
        for (LicenceType licenceType : licenseTypes) {
            Assertions.assertTrue(licenceType.getName().toLowerCase().contains(searchTerm),
                "License type name should contain the search term:" + searchTerm);
        }
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
        List<LicenceType> licenseTypes = licenseTypesFlux.collectList().block();
        Assertions.assertNotNull(licenseTypes, "Find by method should return license types");
        Assertions.assertTrue(licenseTypes.size() >= 5, "Should return at least 5 license types");
    }

    @Test
    @DisplayName("Repository should return an empty list")
    void repositoryShouldReturnEmptyList(){
        //Given
        seedDatabase(
            LicenceType.create("Business License")
        );

        // Act
        var searchTerm = "non existent licence type";
        Flux<LicenceType> licenseTypesFlux = repository.findByNameLikeIgnoreCase(searchTerm, Pageable.ofSize(10));

        // Assert
        List<LicenceType> licenseTypes = licenseTypesFlux.collectList().block();
        Assertions.assertNotNull(licenseTypes, "Find by method should return a list");
        Assertions.assertEquals(0, licenseTypes.size(), "The list should be empty");
    }

    private void seedDatabase(LicenceType... licenceTypes) {
        for (LicenceType licenceType : licenceTypes) {
            StepVerifier.create(repository.insert(licenceType))
                .expectNextCount(1)
                .verifyComplete();
        }
    }
}
