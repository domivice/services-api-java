package org.domivice.services.infrastructure.persistence.mongodb.repositories;

import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.infrastructure.persistence.mongodb.documents.LicenceTypeDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



import java.util.UUID;

public interface LicenceTypeMongoRepository extends LicenceTypeRepository, ReactiveMongoRepository<LicenceTypeDocument, UUID> {
}
