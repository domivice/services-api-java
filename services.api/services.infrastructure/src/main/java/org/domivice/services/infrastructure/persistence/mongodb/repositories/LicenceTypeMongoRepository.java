package org.domivice.services.infrastructure.persistence.mongodb.repositories;

import org.domivice.services.application.licences.LicenceTypeRepository;
import org.domivice.services.domain.entities.LicenceType;
import org.domivice.services.infrastructure.persistence.mongodb.documents.LicenceTypeDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface LicenceTypeMongoRepository extends LicenceTypeRepository, ReactiveMongoRepository<LicenceTypeDocument, UUID>, TextSearchMongoRepository {
    default Flux<LicenceType> searchByLicenceType(String text, Pageable pageable) {
        return this.textSearch(LicenceType.class, LicenceTypeDocument.class, text, pageable);
    }
}
