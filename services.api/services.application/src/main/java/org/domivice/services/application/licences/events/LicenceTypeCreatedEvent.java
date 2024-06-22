package org.domivice.services.application.licences.events;

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
public class LicenceTypeCreatedEvent extends BaseEvent {
    private UUID eventId;
    @JsonProperty("name")
    private String name;
}
