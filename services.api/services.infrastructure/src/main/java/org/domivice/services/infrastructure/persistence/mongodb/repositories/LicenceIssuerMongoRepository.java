package org.domivice.services.infrastructure.persistence.mongodb.repositories;

import org.domivice.services.application.licenceissuers.LicenceIssuerRepository;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.domivice.services.infrastructure.persistence.mongodb.documents.LicenceIssuerDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface LicenceIssuerMongoRepository extends LicenceIssuerRepository, ReactiveMongoRepository<LicenceIssuerDocument, UUID>, TextSearchMongoRepository {
    default Flux<LicenceIssuer> searchByIssuerName(String text, Pageable pageable) {
        return this.textSearch(LicenceIssuer.class, LicenceIssuerDocument.class, text, pageable);
    }
}
