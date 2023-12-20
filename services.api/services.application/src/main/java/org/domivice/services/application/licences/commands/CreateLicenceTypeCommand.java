package org.domivice.services.application.licences.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;

@Data
@SuperBuilder
public class CreateLicenceTypeCommand extends BaseCommand {
    @NotBlank
    private String name;
}
