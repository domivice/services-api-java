package org.domivice.services.infrastructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.domivice.services.domain.entities.LicenceType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("licenceTypes")
public class LicenceTypeDocument extends LicenceType {
    @Id
    private UUID id;
}
