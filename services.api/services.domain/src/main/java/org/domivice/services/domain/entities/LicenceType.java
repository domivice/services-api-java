package org.domivice.services.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class LicenceType extends BaseEntity<UUID> {
    protected String name;

    protected LicenceType() {
    }

    private LicenceType(UUID id, String name) {
        this.name = name;
        this.id = id;
        this.created = ZonedDateTime.now(ZoneOffset.UTC);
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }

    private LicenceType(UUID id, String name, ZonedDateTime create, ZonedDateTime updated) {
        this.name = name;
        this.id = id;
        this.created = create;
        this.updated = updated;
    }

    public static LicenceType create(UUID id, String name) {
        return new LicenceType(id, name);
    }

    protected static LicenceType build(UUID id, String name, ZonedDateTime create, ZonedDateTime updated) {
        return new LicenceType(id, name, create, updated);
    }

    public void changeName(String newName) {
        this.name = newName;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
}
