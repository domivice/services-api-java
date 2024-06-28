package org.domivice.services.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public class LicenceIssuer extends BaseEntity<UUID> {
    protected String issuerName;
    protected String issuingCountryCode;
    protected String issuingStateCode;
    protected UUID licenceTypeId;

    protected LicenceIssuer() {
    }

    private LicenceIssuer(UUID id, String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId) {
        this.issuerName = issuerName;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
        this.licenceTypeId = licenceTypeId;
        this.id = id;
        this.created = ZonedDateTime.now(ZoneOffset.UTC);
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }

    private LicenceIssuer(UUID id, String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId, ZonedDateTime created, ZonedDateTime updated) {
        this.issuerName = issuerName;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
        this.licenceTypeId = licenceTypeId;
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public static LicenceIssuer create(UUID id, String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId) {
        return new LicenceIssuer(id, issuerName, issuingCountryCode, issuingStateCode, licenceTypeId);
    }

    protected static LicenceIssuer build(UUID id, String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId, ZonedDateTime created, ZonedDateTime updated) {
        return new LicenceIssuer(id, issuerName, issuingCountryCode, issuingStateCode, licenceTypeId, created, updated);
    }

    public void changeName(String issuerName) {
        this.issuerName = issuerName;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
    public void changeCountryCode(String countryCode){
        this.issuingCountryCode = countryCode;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
    public void changeStateCode(String stateCode){
        this.issuingStateCode = stateCode;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
    public void changeLicenceTypeId(UUID licenceTypeId){
        this.licenceTypeId = licenceTypeId;
        this.updated = ZonedDateTime.now(ZoneOffset.UTC);
    }
}
