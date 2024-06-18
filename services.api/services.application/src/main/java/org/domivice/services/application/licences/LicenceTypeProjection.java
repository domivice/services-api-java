package org.domivice.services.application.licences;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.services.application.licences.events.LicenceTypeCreatedEvent;
import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licences.queries.GetLicenceTypesByName;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class LicenceTypeProjection {
    private final LicenceTypeRepository repository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(@NotNull LicenceTypeCreatedEvent event) {
        log.debug("Handling event {}", event);
        var licenceType = LicenceType.create(event.getName());

        repository.insert(licenceType).subscribe(insertedLicenceType -> queryUpdateEmitter.emit(GetLicenceTypeQuery.class,
            getLicenceTypeQuery -> getLicenceTypeQuery.getId().equals(event.getId()),
            insertedLicenceType));
    }

    @QueryHandler
    public Mono<LicenceType> handle(GetLicenceTypeQuery query) {
        log.debug("Handling query {}", query);
        return repository.findOneById(query.getLicenceTypeId());
    }

    @QueryHandler
    public Flux<LicenceType> handle(GetLicenceTypesByName query) {
        log.debug("Handling query {}", query);

        if (query.getName() == null || query.getName().isEmpty()) {
            return repository.findBy(PageRequest.of(
                    query.getPage() - 1,
                    query.getPageSize(),
                    query.getSortQuery()
                )
            );
        }

        return repository.searchByLicenceType(
            query.getName(),
            PageRequest.of(
                query.getPage() - 1,
                query.getPageSize(),
                query.getSortQuery()
            )
        );
    }
}
