package org.domivice.services.application.licencetypes;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.services.application.licencetypes.events.LicenceTypeCreatedEvent;
import org.domivice.services.application.licencetypes.events.LicenceTypeDeletedEvent;
import org.domivice.services.application.licencetypes.events.LicenceTypeUpdatedEvent;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypeQuery;
import org.domivice.services.application.licencetypes.queries.GetLicenceTypesByNameQuery;
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
        log.debug("Handling LicenceTypeCreatedEvent {}", event);
        repository.existsById(event.getAggregateId())
            .flatMap(exists -> {
                if (exists.equals(Boolean.TRUE)) {
                    log.debug("LicenceType with id {} already exists. Skipping insert.", event.getAggregateId());
                    return Mono.empty();
                } else {
                    LicenceType licenceType = LicenceType.create(event.getAggregateId(), event.getName());
                    return repository.insert(licenceType)
                        .doOnNext(insertedLicenceType -> queryUpdateEmitter.emit(
                            GetLicenceTypeQuery.class,
                            query -> query.getAggregateId().equals(event.getAggregateId()),
                            insertedLicenceType
                        ));
                }
            }).onErrorResume(e -> {
                log.error("Error handling LicenceTypeCreatedEvent for id {}: {}", event.getAggregateId(), e.getMessage());
                return Mono.empty(); // or handle the error accordingly
            }).subscribe();
    }

    @EventHandler
    public void on(@NotNull LicenceTypeUpdatedEvent event) {
        log.debug("Handling LicenceTypeUpdatedEvent {}", event);

        // Update the licence type in the repository
        repository.findOneById(event.getAggregateId()).flatMap(existingLicenceType -> {
            existingLicenceType.changeName(event.getName());
            return repository.update(existingLicenceType);
        }).subscribe(updatedLicenceType ->
            // Emit the updated licence type to any interested queries
            queryUpdateEmitter.emit(GetLicenceTypeQuery.class,
                getLicenceTypeQuery -> getLicenceTypeQuery.getAggregateId().equals(event.getAggregateId()),
                updatedLicenceType)
        );
    }

    @EventHandler
    public void on(@NotNull LicenceTypeDeletedEvent event) {
        log.debug("Handling LicenceTypeDeletedEvent {}", event);
        repository.findOneById(event.getAggregateId())
            .flatMap(licenceType -> repository.delete(licenceType.getId()))
            .subscribe();
    }

    @QueryHandler
    public Mono<LicenceType> handle(GetLicenceTypeQuery query) {
        log.debug("Handling GetLicenceTypeQuery {}", query);
        return repository.findOneById(query.getLicenceTypeId());
    }

    @QueryHandler
    public Flux<LicenceType> handle(GetLicenceTypesByNameQuery query) {
        log.debug("Handling GetLicenceTypesByName {}", query);

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
