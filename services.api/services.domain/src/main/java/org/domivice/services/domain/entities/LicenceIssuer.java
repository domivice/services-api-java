package org.domivice.services.domain.entities;

import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class LicenceIssuer extends BaseEntity<UUID> {
    private String issuerName;
    private String issuingCountryCode;
    private String issuingStateCode;
    private UUID licenceTypeId;

    private LicenceIssuer(String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId) {
        this.issuerName = issuerName;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
        this.licenceTypeId = licenceTypeId;
        this.id = UUID.randomUUID();
        this.created = ZonedDateTime.now(ZoneOffset.UTC);
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }

    protected LicenceIssuer() {
    }

    public static LicenceIssuer create(String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId) {
        return new LicenceIssuer(issuerName, issuingCountryCode, issuingStateCode, licenceTypeId);
    }
}
