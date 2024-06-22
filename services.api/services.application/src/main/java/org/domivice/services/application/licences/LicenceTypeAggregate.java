package org.domivice.services.application.licences;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.commands.DeleteLicenceTypeCommand;
import org.domivice.services.application.licences.commands.UpdateLicenceTypeCommand;
import org.domivice.services.application.licences.events.LicenceTypeCreatedEvent;
import org.domivice.services.application.licences.events.LicenceTypeDeletedEvent;
import org.domivice.services.application.licences.events.LicenceTypeUpdatedEvent;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Slf4j
public class LicenceTypeAggregate {
    @AggregateIdentifier
    private UUID id;
    private String name;

    @CommandHandler
    public LicenceTypeAggregate(@NotNull CreateLicenceTypeCommand command) {
        log.debug("Handling create command {}", command);
        AggregateLifecycle.apply(LicenceTypeCreatedEvent
            .builder()
            .eventId(UUID.randomUUID())
            .aggregateId(command.getAggregateId())
            .name(command.getName()).build()
        );
    }

    @CommandHandler
    public void handle(@NotNull UpdateLicenceTypeCommand command) {
        log.debug("Handling update command {}", command);
        AggregateLifecycle.apply(LicenceTypeUpdatedEvent
            .builder()
            .eventId(UUID.randomUUID())
            .aggregateId(command.getAggregateId())
            .name(command.getName()).build()
        );
    }

    @CommandHandler
    public void handle(@NotNull DeleteLicenceTypeCommand command) {
        log.debug("Handling delete command {}", command);
        AggregateLifecycle.apply(LicenceTypeDeletedEvent.builder()
            .aggregateId(command.getAggregateId())
            .eventId(UUID.randomUUID())
            .build()
        );
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceTypeCreatedEvent event) {
        id = event.getAggregateId();
        name = event.getName();
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceTypeUpdatedEvent event) {
        name = event.getName();
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceTypeDeletedEvent event) {
        name = null;
    }
}
