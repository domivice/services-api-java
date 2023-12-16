package org.domivice.services.application.licences;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.domivice.services.application.licences.commands.CreateLicenceTypeCommand;
import org.domivice.services.application.licences.events.LicenceTypeCreatedEvent;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class LicenceTypeAggregate {
    @AggregateIdentifier
    private UUID id;
    private String name;

    @CommandHandler
    public LicenceTypeAggregate(@NotNull CreateLicenceTypeCommand command) {
        LicenceTypeCreatedEvent event = LicenceTypeCreatedEvent
                .builder()
                .id(command.getId())
                .name(command.getName()).build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceTypeCreatedEvent event){
        id = event.getId();
        name = event.getName();
    }
}
