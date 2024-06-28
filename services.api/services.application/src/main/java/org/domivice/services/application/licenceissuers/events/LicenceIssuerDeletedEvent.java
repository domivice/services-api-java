package org.domivice.services.application.licenceissuers.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.events.BaseEvent;

@Data
@SuperBuilder
//@AllArgsConstructor
@NoArgsConstructor
public class LicenceIssuerDeletedEvent extends BaseEvent {
}
