package org.domivice.services.application.licences;

import org.domivice.services.domain.entities.LicenceType;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface LicenceTypeRepository {
    Mono<LicenceType> insert(LicenceType licenceType);

    Mono<LicenceType> findOneById(UUID id);
}
