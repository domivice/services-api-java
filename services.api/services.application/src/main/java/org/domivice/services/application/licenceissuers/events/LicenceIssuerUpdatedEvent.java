package org.domivice.services.application.licenceissuers.events;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.events.BaseEvent;

import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LicenceIssuerUpdatedEvent extends BaseEvent {
    private String issuerName;
    private String issuingCountryCode;
    private String issuingStateCode;
    private UUID licenceTypeId;
}
