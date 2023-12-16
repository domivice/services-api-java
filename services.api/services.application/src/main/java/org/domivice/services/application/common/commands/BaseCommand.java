package org.domivice.services.application.common.commands;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@SuperBuilder
public class BaseCommand {
    @TargetAggregateIdentifier
    private UUID id;
}
