package org.domivice.services.application.licences;

import org.domivice.services.domain.entities.LicenceType;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface LicenceTypeRepository {
    Mono<LicenceType> insert(LicenceType licenceType);

    Mono<LicenceType> findOneById(UUID id);

    Flux<LicenceType> findBy(Pageable pageable);

    Flux<LicenceType> searchByLicenceType(String text, Pageable pageable);

    Mono<Boolean> existsById(UUID id);

    Mono<Void> deleteAll();
}
