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
}
