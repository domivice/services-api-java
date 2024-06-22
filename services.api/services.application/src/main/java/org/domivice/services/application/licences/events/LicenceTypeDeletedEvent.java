package org.domivice.services.application.licences.events;

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
public class LicenceTypeDeletedEvent extends BaseEvent {
    private UUID eventId;
}
