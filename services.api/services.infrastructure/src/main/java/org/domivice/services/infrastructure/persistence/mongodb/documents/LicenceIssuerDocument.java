package org.domivice.services.infrastructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("licenceIssuers")
public class LicenceIssuerDocument extends LicenceIssuer {
    @Id
    private UUID id;
}
