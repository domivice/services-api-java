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
import org.domivice.services.application.licenceissuers.events.LicenceIssuerCreatedEvent;

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
        log.debug("Handling command {}", command);
        AggregateLifecycle.apply(LicenceIssuerCreatedEvent
            .builder()
            .id(command.getId())
            .issuerName(command.getIssuerName())
            .issuingCountryCode(command.getIssuingCountryCode())
            .issuingStateCode(command.getIssuingStateCode())
            .licenceTypeId(command.getLicenceTypeId())
            .build());
    }

    @EventSourcingHandler
    public void on(@NotNull LicenceIssuerCreatedEvent event) {
        id = event.getId();
        issuerName = event.getIssuerName();
        issuingCountryCode = event.getIssuingCountryCode();
        issuingStateCode = event.getIssuingStateCode();
        licenceTypeId = event.getLicenceTypeId();
    }
}
