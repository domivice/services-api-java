package org.domivice.services.application.licenceissuers.events;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class LicenceIssuerCreatedEvent extends BaseEvent {
    @JsonProperty("issuerName")
    private String issuerName;
    @JsonProperty("issuingCountryCode")
    private String issuingCountryCode;
    @JsonProperty("issuingStateCode")
    private String issuingStateCode;
    @JsonProperty("licenceTypeId")
    private UUID licenceTypeId;
}
