package org.domivice.services.application.licences;

import org.domivice.domain.entities.LicenceType;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface LicenceTypeRepository {
    Mono<LicenceType> insert(LicenceType licenceType);
    Mono<LicenceType> findOneById(UUID id);
}
