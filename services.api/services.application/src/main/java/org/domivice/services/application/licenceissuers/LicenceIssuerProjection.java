package org.domivice.services.application.licenceissuers;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerCreatedEvent;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerDeletedEvent;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerUpdatedEvent;
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
    private final LicenceIssuerRepository licenceIssuerRepository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(@NotNull LicenceIssuerCreatedEvent event) {
        log.debug("Handling LicenceIssuerCreatedEvent {}", event);

        licenceIssuerRepository.existsById(event.getAggregateId())
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
                    return licenceIssuerRepository.insert(licenceIssuer)
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

    @EventHandler
    public void on(@NotNull LicenceIssuerDeletedEvent event) {
        log.debug("Handling LicenceIssuerDeletedEvent {}", event);
        licenceIssuerRepository.findOneById(event.getAggregateId())
            .flatMap(licenceIssuer -> licenceIssuerRepository.delete(licenceIssuer.getId()))
            .subscribe();
    }

    @EventHandler
    public void on(@NotNull LicenceIssuerUpdatedEvent event) {
        log.debug("Handling LicenceIssuerUpdatedEvent {}", event);
        licenceIssuerRepository.findOneById(event.getAggregateId())
            .flatMap(licenceIssuer -> {
                if (event.getIssuerName() != null) {
                    licenceIssuer.changeName(event.getIssuerName());
                }
                if (event.getIssuingCountryCode() != null) {
                    licenceIssuer.changeCountryCode(event.getIssuingCountryCode());
                }
                if (event.getIssuingStateCode() != null) {
                    licenceIssuer.changeStateCode(event.getIssuingStateCode());
                }
                if (event.getLicenceTypeId() != null) {
                    licenceIssuer.changeLicenceTypeId(event.getLicenceTypeId());
                }
                return licenceIssuerRepository.update(licenceIssuer);
            }).subscribe(updateLicenceIssuer -> queryUpdateEmitter.emit(
                GetLicenceIssuerQuery.class,
                query -> query.getAggregateId().equals(event.getAggregateId()),
                updateLicenceIssuer
            ));
    }

    @QueryHandler
    public Mono<LicenceIssuer> handle(@NotNull GetLicenceIssuerQuery query) {
        log.debug("Handling GetLicenceIssuerQuery {}", query);
        return licenceIssuerRepository.findOneById(query.getLicenceIssuerId());
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByStateCodeQuery query) {
        log.debug("Handling GetLicenceIssuerByStateCodeQuery {}", query);
        return licenceIssuerRepository.findByIssuingStateCode(query.getIssuingStateCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByCountryCodeQuery query) {
        log.debug("Handling GetLicenceIssuerByCountryCodeQuery {}", query);
        return licenceIssuerRepository.findByIssuingCountryCode(query.getIssuingCountryCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull SearchLicenceIssuerQuery query) {
        log.debug("Handling SearchLicenceIssuerQuery {}", query);
        return licenceIssuerRepository.searchByIssuerName(query.getSearchTerm(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

}
