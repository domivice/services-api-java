package org.domivice.services.application.licenceissuers;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.domivice.services.application.licenceissuers.commands.CreateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.DeleteLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.commands.UpdateLicenceIssuerCommand;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerCreatedEvent;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerDeletedEvent;
import org.domivice.services.application.licenceissuers.events.LicenceIssuerUpdatedEvent;

import java.util.UUID;

@Aggregate
@Slf4j
@NoArgsConstructor
public class LicenceIssuerAggregate {
    @AggregateIdentifier
    private UUID id;
    private String issuerName;
    private String issuingCountryCode;
    private String issuingStateCode;
    private UUID licenceTypeId;

    @CommandHandler
    public LicenceIssuerAggregate(@NotNull CreateLicenceIssuerCommand command) {
        log.debug("Handling CreateLicenceIssuerCommand {}", command);
        AggregateLifecycle.apply(LicenceIssuerCreatedEvent
            .builder()
            .aggregateId(command.getAggregateId())
            .eventId(UUID.randomUUID())
            .issuerName(command.getIssuerName())
            .issuingCountryCode(command.getIssuingCountryCode())
            .issuingStateCode(command.getIssuingStateCode())
            .licenceTypeId(command.getLicenceTypeId())
            .build()
        );
    }

    @CommandHandler
    public void on(@NotNull UpdateLicenceIssuerCommand command) {
        log.debug("Handling UpdateLicenceIssuerCommand {}", command);
        AggregateLifecycle.apply(LicenceIssuerUpdatedEvent
            .builder()
            .aggregateId(command.getAggregateId())
            .eventId(UUID.randomUUID())
            .issuerName(command.getIssuerName())
            .issuingCountryCode(command.getIssuingCountryCode())
            .issuingStateCode(command.getIssuingStateCode())
            .licenceTypeId(command.getLicenceTypeId())
            .build()
        );
    }

    @CommandHandler
    public void on(@NotNull DeleteLicenceIssuerCommand command) {
        log.debug("Handling DeleteLicenceIssuerCommand {}", command);
        AggregateLifecycle.apply(LicenceIssuerDeletedEvent
            .builder()
            .aggregateId(command.getAggregateId())
            .eventId(UUID.randomUUID())
            .build()
        );
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceIssuerCreatedEvent event) {
        id = event.getAggregateId();
        issuerName = event.getIssuerName();
        issuingCountryCode = event.getIssuingCountryCode();
        issuingStateCode = event.getIssuingStateCode();
        licenceTypeId = event.getLicenceTypeId();
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceIssuerUpdatedEvent event) {
        issuerName = event.getIssuerName();
        issuingCountryCode = event.getIssuingCountryCode();
        issuingStateCode = event.getIssuingStateCode();
        licenceTypeId = event.getLicenceTypeId();
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceIssuerDeletedEvent event) {
        issuerName = null;
        issuingCountryCode = null;
        issuingStateCode = null;
        licenceTypeId = null;
    }
}
