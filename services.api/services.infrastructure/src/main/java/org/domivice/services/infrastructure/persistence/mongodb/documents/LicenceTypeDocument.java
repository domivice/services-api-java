package org.domivice.services.infrastructure.persistence.mongodb.documents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Document("licenceTypes")
public class LicenceTypeDocument extends LicenceType {
    @Id
    private UUID id;

    private LicenceTypeDocument(UUID id, String name, ZonedDateTime create, ZonedDateTime updated) {
        this.name = name;
        this.id = id;
        this.created = create;
        this.updated = updated;
    }

    public static LicenceTypeDocument fromEntity(LicenceType licenceType) {
        return new LicenceTypeDocument(licenceType.getId(), licenceType.getName(), licenceType.getCreated(), licenceType.getUpdated());
    }

    public LicenceType toEntity() {
        return LicenceType.build(id, name, created, updated);
    }
}
