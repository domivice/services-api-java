package org.domivice.services.application.licencetypes.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;
import org.domivice.services.application.common.validators.ValidDisplayName;

import java.util.UUID;

@Data
@SuperBuilder
public class UpdateLicenceTypeCommand extends BaseCommand {
    @NotBlank
    @ValidDisplayName
    private String name;
}
