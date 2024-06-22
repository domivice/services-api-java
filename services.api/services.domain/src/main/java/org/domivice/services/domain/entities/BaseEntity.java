package org.domivice.services.domain.entities;


import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public abstract class BaseEntity<T> {
    protected T id;
    protected ZonedDateTime created;
    protected ZonedDateTime updated;
}
