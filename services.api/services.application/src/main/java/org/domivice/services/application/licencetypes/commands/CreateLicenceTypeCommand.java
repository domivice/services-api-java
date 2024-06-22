package org.domivice.services.application.licencetypes.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;

import java.util.UUID;

@Data
@SuperBuilder
public class CreateLicenceTypeCommand extends BaseCommand {
    private UUID commandId;
    @NotBlank
    private String name;
}
