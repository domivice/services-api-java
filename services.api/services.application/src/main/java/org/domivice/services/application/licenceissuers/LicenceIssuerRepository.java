package org.domivice.services.application.licenceissuers;

import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LicenceIssuerRepository {
    Mono<LicenceIssuer> insert(LicenceIssuer licenceIssuer);

    Mono<LicenceIssuer> findOneById(UUID id);

    Flux<LicenceIssuer> findBy(Pageable pageable);

    Flux<LicenceIssuer> findByIssuingCountryCode(String issuingCountryCode, Pageable pageable);

    Flux<LicenceIssuer> findByIssuingStateCode(String issuingStateCode, Pageable pageable);

    Flux<LicenceIssuer> searchByIssuerName(String text, Pageable pageable);

    Mono<Boolean> existsById(UUID id);

    Mono<Void> deleteAll();
}
