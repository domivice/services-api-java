package org.domivice.services.application.licenceissuers;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerCreatedEvent;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByCountryCode;
import org.domivice.services.application.licenceissuers.queries.GetLicenceIssuerByStateCode;
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
        log.debug("Handling event {}", event);
        var licenceIssuer = LicenceIssuer.create(
            event.getIssuerName(),
            event.getIssuingCountryCode(),
            event.getIssuingStateCode(),
            event.getLicenceTypeId()
        );
        repository.insert(licenceIssuer)
            .subscribe(insertedLicenceIssuer -> queryUpdateEmitter
                .emit(GetLicenceIssuerQuery.class,
                    getLicenceIssuerQuery -> getLicenceIssuerQuery.getId().equals(event.getId()),
                    insertedLicenceIssuer)
            );
    }

    @QueryHandler
    public Mono<LicenceIssuer> handle(@NotNull GetLicenceIssuerQuery query) {
        log.debug("Handling query {}", query);
        return repository.findOneById(query.getLicenceIssuerId());
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByStateCode query) {
        log.debug("Handling query {}", query);
        return repository.findByIssuingStateCode(query.getIssuingStateCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull GetLicenceIssuerByCountryCode query) {
        log.debug("Handling query {}", query);
        return repository.findByIssuingCountryCode(query.getIssuingCountryCode(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

    @QueryHandler
    public Flux<LicenceIssuer> handle(@NotNull SearchLicenceIssuerQuery query) {
        log.debug("Handling query {}", query);
        return repository.searchByIssuerName(query.getSearchTerm(), PageRequest.of(
            query.getPage() - 1,
            query.getPageSize(),
            query.getSortQuery()
        ));
    }

}
