package org.domivice.services.application.licenceissuers.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;
import org.domivice.services.application.common.validators.ValidDisplayName;

import java.util.UUID;

@Data
@SuperBuilder
public class CreateLicenceIssuerCommand extends BaseCommand {
    //@NotBlank
    @ValidDisplayName
    @NotBlank
    private String issuerName;
    @NotBlank
    private String issuingCountryCode;
    @NotBlank
    private String issuingStateCode;
    @NotNull
    private UUID licenceTypeId;
}
