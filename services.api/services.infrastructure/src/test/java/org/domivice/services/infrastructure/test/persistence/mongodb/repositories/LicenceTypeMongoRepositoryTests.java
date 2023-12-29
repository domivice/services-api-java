package org.domivice.services.infrastructure.test.persistence.mongodb.repositories;

import org.domivice.domain.entities.LicenceType;
import org.domivice.services.infrastructure.persistence.mongodb.repositories.LicenceTypeMongoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LicenceTypeMongoRepository.class)
public class LicenceTypeMongoRepositoryTests extends AbstractMongoDbContainerBaseTest {
    @Autowired
    private LicenceTypeMongoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll().subscribe();
    }

    @Test
    @DisplayName("Repository Should Insert Licence Type Success")
    public void repositoryShouldInsertLicenceTypeSuccess() {
        var licenceType = LicenceType.create("Licence Type");
        var insertedLicenceType = repository.insert(licenceType).block();
        Assertions.assertNotNull(insertedLicenceType);
        Assertions.assertEquals(insertedLicenceType.getClass(), LicenceType.class);
    }

    @Test
    @DisplayName("Repository Should Find One Licence Type Success")
    public void repositoryShouldFindOneLicenceTypeSuccess() {
        var licenceType = LicenceType.create("Licence Type");
        var insertedLicenceType = repository.insert(licenceType).block();
        Assertions.assertNotNull(insertedLicenceType);
        var retrievedLicenceType = repository.findOneById(insertedLicenceType.getId()).block();
        Assertions.assertNotNull(retrievedLicenceType);
        Assertions.assertEquals(insertedLicenceType.getId(), retrievedLicenceType.getId());
    }
}
