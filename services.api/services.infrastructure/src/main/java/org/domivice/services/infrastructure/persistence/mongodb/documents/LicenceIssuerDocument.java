package org.domivice.services.infrastructure.persistence.mongodb.documents;

import lombok.*;
import org.domivice.services.domain.entities.LicenceIssuer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Document("licenceIssuers")
public class LicenceIssuerDocument extends LicenceIssuer {
    @Id
    private UUID id;

    private LicenceIssuerDocument(UUID id, String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId, ZonedDateTime created, ZonedDateTime updated) {
        this.issuerName = issuerName;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
        this.licenceTypeId = licenceTypeId;
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public static LicenceIssuerDocument fromEntity(LicenceIssuer licenceIssuer) {
        return new LicenceIssuerDocument(licenceIssuer.getId(), licenceIssuer.getIssuerName(), licenceIssuer.getIssuingCountryCode(), licenceIssuer.getIssuingStateCode(), licenceIssuer.getLicenceTypeId(), licenceIssuer.getCreated(), licenceIssuer.getUpdated());
    }

    public LicenceIssuer toEntity() {
        return LicenceIssuer.build(id, issuerName, issuingCountryCode, issuingStateCode, licenceTypeId, created, updated);
    }
}
