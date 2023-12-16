package org.domivice.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@SuperBuilder
public abstract class BaseEntity<T> {
    private T id;
    private ZonedDateTime created;
    private ZonedDateTime updated;
}
