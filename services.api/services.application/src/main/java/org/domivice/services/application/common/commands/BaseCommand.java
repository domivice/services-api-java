package org.domivice.services.application.common.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseCommand {
    @TargetAggregateIdentifier
    @JsonProperty("aggregateId")
    @NotNull
    private UUID aggregateId;
    private UUID commandId;
}
