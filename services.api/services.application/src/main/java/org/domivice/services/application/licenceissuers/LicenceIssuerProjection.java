package org.domivice.services.application.licenceissuers;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerCreatedEvent;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByCountryCodeQuery;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByStateCodeQuery;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerQuery;
import org.domivice.services.application.licenceissuers.queries.SearchLicenceIssuerQuery;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@AllArgsConstructor
public class LicenceIssuerProjection {
    private final LicenceIssuerRepository repository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(@NotNull LicenceIssuerCreatedEvent event) {
        log.debug("Handling LicenceIssuerCreatedEvent {}", event);

        repository.existsById(event.getAggregateId())
            .flatMap(exists -> {
                if (exists.equals(Boolean.TRUE)) {
                    log.debug("LicenceIssuer with id {} already exists. Skipping insert.", event.getAggregateId());
                    return Mono.empty();
                } else {
                    LicenceIssuer licenceIssuer = LicenceIssuer.create(
                        event.getAggregateId(),
                        event.getIssuerName(),
                        event.getIssuingCountryCode(),
                        event.getIssuingStateCode(),
                        event.getLicenceTypeId()
                    );
                    return repository.insert(licenceIssuer)
                        .doOnNext(insertedLicenceIssuer -> queryUpdateEmitter.emit(
                            GetLicenceIssuerQuery.class,
                            query -> query.getAggregateId().equals(event.getAggregateId()),
                            insertedLicenceIssuer
                        ));
                }
            }).onErrorResume(e -> {
                log.error("Error handling LicenceIssuerCreatedEvent for id {}: {}", event.getAggregateId(), e.getMessage());
                return Mono.empty(); // or handle the error accordingly
            }).subscribe();
    }

    @QueryHandler
    public Mono<LicenceIssuer> handle(@NotNull GetLicenceIssuerQuery query) {
        log.debug("Handling GetLicenceIssuerQuery {}", query);
        return repository.findOneById(query.getLicenceIssuerId());
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByStateCodeQuery query) {
        log.debug("Handling GetLicenceIssuerByStateCodeQuery {}", query);
        return repository.findByIssuingStateCode(query.getIssuingStateCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByCountryCodeQuery query) {
        log.debug("Handling GetLicenceIssuerByCountryCodeQuery {}", query);
        return repository.findByIssuingCountryCode(query.getIssuingCountryCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull SearchLicenceIssuerQuery query) {
        log.debug("Handling SearchLicenceIssuerQuery {}", query);
        return repository.searchByIssuerName(query.getSearchTerm(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

}
