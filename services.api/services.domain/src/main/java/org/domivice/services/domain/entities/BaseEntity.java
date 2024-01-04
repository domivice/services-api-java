package org.domivice.services.domain.entities;


import lombok.Data;

import java.time.ZonedDateTime;

@Data
public abstract class BaseEntity<T> {
    protected T id;
    protected ZonedDateTime created;
    protected ZonedDateTime updated;
}
