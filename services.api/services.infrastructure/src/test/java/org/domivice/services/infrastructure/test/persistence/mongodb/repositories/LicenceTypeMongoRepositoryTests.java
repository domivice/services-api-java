package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.infrastructure.persistence.mongodb.repositories.LicenceTypeMongoRepository;
import org.domivice.services.infrastructure.test.persistence.mongodb.MongoInfra;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LicenceTypeMongoRepository.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LicenceTypeMongoRepositoryTests extends MongoInfra {
    @Autowired
    private LicenceTypeMongoRepository repository;

    @BeforeAll
    void setUp() {
        repository.deleteAll().subscribe();
    }

    @Test
    @DisplayName("Repository Should Insert Licence Type Success")
    void repositoryShouldInsertLicenceTypeSuccess() {
        var licenceType = LicenceType.create("Licence Type");
        var insertedLicenceType = repository.insert(licenceType).block();
        Assertions.assertNotNull(insertedLicenceType);
        Assertions.assertEquals(insertedLicenceType.getClass(), LicenceType.class);
    }

    @Test
    @DisplayName("Repository Should Find One Licence Type Success")
    void repositoryShouldFindOneLicenceTypeSuccess() {
        var licenceType = LicenceType.create("Licence Type");
        var insertedLicenceType = repository.insert(licenceType).block();
        Assertions.assertNotNull(insertedLicenceType);
        var retrievedLicenceType = repository.findOneById(insertedLicenceType.getId()).block();
        Assertions.assertNotNull(retrievedLicenceType);
        Assertions.assertEquals(insertedLicenceType.getId(), retrievedLicenceType.getId());
    }

    @Test
    @DisplayName("Repository Should Search Licence Types by name")
    void repositoryShouldFindByNameLikeSuccess() {
        // Arrange: Insert LicenseType records
        repository.insert(LicenceType.create("Driver's Licence")).block();
        repository.insert(LicenceType.create("Medical Licence")).block();
        repository.insert(LicenceType.create("Psychiatrist Licence")).block();

        // Act: Search for LicenseType by name
        var licenceType = repository.findByNameLikeIgnoreCase("Licence").blockFirst();

        // Assert: Verify the found LicenceType
        Assertions.assertNotNull(licenceType, "Found LicenceType should not be null");
        Assertions.assertEquals("Driver's Licence", licenceType.getName(), "Found LicenceType name should match search criteria");

        // Additional assertions for improved test coverage
        var nonExistentLicenceType = repository.findByNameLikeIgnoreCase("Non-existent").blockFirst();
        Assertions.assertNull(nonExistentLicenceType, "Non-existent LicenceType should be null");

        var caseInsensitiveLicenceType = repository.findByNameLikeIgnoreCase("licence").blockFirst();
        Assertions.assertNotNull(caseInsensitiveLicenceType, "Case-insensitive search should find a LicenceType");
        Assertions.assertEquals("Driver's Licence", caseInsensitiveLicenceType.getName(), "Case-insensitive search should match");
    }
}
