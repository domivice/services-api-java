package org.domivice.services.domain.entities;

import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class LicenceType extends BaseEntity<UUID> {
    private String name;

    private LicenceType(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.created = ZonedDateTime.now(ZoneOffset.UTC);
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }

    protected LicenceType() {
    }

    public static LicenceType create(String name) {
        return new LicenceType(name);
    }

    public void changeName(String newName) {
        this.name = newName;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
}
