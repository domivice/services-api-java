package org.domivice.services.application.licences.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.events.BaseEvent;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LicenceTypeCreatedEvent extends BaseEvent {
    @JsonProperty("name")
    private String name;
}
