package org.domivice.services.application.licenceissuers.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;
import org.domivice.services.application.common.validators.ValidDisplayName;

import java.util.UUID;

@Data
@SuperBuilder
public class UpdateLicenceIssuerCommand extends BaseCommand {
    @ValidDisplayName
    private String issuerName;
    private String issuingCountryCode;
    private String issuingStateCode;
    private UUID licenceTypeId;
}
