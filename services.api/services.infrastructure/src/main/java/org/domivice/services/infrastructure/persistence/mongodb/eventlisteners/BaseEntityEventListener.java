package org.domivice.services.infrastructure.persistence.mongodb.eventlisteners;

import org.domivice.domain.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.TimeZone;
import java.util.UUID;

@Component
public class BaseEntityEventListener extends AbstractMongoEventListener<BaseEntity<UUID>> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseEntity<UUID>> event) {
        super.onBeforeConvert(event);
        BaseEntity<UUID> entity = event.getSource();
        if(entity.getId() == null){
            entity.setId(UUID.randomUUID());
        }
        if(entity.getCreated() == null){
            entity.setCreated(ZonedDateTime.now());
        }
        entity.setUpdated(ZonedDateTime.now());
    }
}
