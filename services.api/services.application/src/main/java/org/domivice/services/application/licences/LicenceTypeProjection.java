package org.domivice.services.application.licences;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.domivice.domain.entities.LicenceType;
import org.domivice.services.application.licences.events.LicenceTypeCreatedEvent;
import org.domivice.services.application.licences.queries.GetLicenceTypeQuery;
import org.springframework.stereotype.Component;
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
                insertedLicenceType)
        );
    }

    @QueryHandler
    public Mono<LicenceType> handle(GetLicenceTypeQuery query) {
        log.debug("Handling query {}", query);
        return repository.findOneById(query.getLicenceTypeId());
    }
}
