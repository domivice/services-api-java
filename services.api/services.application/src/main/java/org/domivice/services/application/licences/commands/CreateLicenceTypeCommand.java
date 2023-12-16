package org.domivice.services.application.licences.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateLicenceTypeCommand extends BaseCommand {
    @NotBlank
    private String name;
}
