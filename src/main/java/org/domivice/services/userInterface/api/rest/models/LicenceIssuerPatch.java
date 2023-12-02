package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Objects;
import java.util.UUID;

/**
 * Carries license type information
 */

@Schema(name = "LicenceIssuerPatch", description = "Carries license type information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class LicenceIssuerPatch {

    private UUID id;

    private String issuerName;

    private String issuingCountryCode;

    private String issuingStateCode;

    private UUID licenceTypeId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceIssuerPatch#LicenceIssuerPatch(UUID)}
     */
    @Deprecated
    public LicenceIssuerPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceIssuerPatch(UUID id) {
        this.id = id;
    }

    public LicenceIssuerPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The licence issuer id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The licence issuer id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LicenceIssuerPatch issuerName(String issuerName) {
        this.issuerName = issuerName;
        return this;
    }

    /**
     * The licence issuer e.g. Société de l'assurance automobile du Québec (SAAQ)
     *
     * @return issuerName
     */

    @Schema(name = "issuerName", description = "The licence issuer e.g. Société de l'assurance automobile du Québec (SAAQ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("issuerName")
    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public LicenceIssuerPatch issuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
        return this;
    }

    /**
     * The issuing Country
     *
     * @return issuingCountryCode
     */

    @Schema(name = "issuingCountryCode", description = "The issuing Country", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("issuingCountryCode")
    public String getIssuingCountryCode() {
        return issuingCountryCode;
    }

    public void setIssuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
    }

    public LicenceIssuerPatch issuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
        return this;
    }

    /**
     * The licence issuing state
     *
     * @return issuingStateCode
     */

    @Schema(name = "issuingStateCode", description = "The licence issuing state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("issuingStateCode")
    public String getIssuingStateCode() {
        return issuingStateCode;
    }

    public void setIssuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
    }

    public LicenceIssuerPatch licenceTypeId(UUID licenceTypeId) {
        this.licenceTypeId = licenceTypeId;
        return this;
    }

    /**
     * The licence type this issuer can issue
     *
     * @return licenceTypeId
     */
    @Valid
    @Schema(name = "licenceTypeId", description = "The licence type this issuer can issue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("licenceTypeId")
    public UUID getLicenceTypeId() {
        return licenceTypeId;
    }

    public void setLicenceTypeId(UUID licenceTypeId) {
        this.licenceTypeId = licenceTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LicenceIssuerPatch licenceIssuerPatch = (LicenceIssuerPatch) o;
        return Objects.equals(this.id, licenceIssuerPatch.id) &&
                Objects.equals(this.issuerName, licenceIssuerPatch.issuerName) &&
                Objects.equals(this.issuingCountryCode, licenceIssuerPatch.issuingCountryCode) &&
                Objects.equals(this.issuingStateCode, licenceIssuerPatch.issuingStateCode) &&
                Objects.equals(this.licenceTypeId, licenceIssuerPatch.licenceTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issuerName, issuingCountryCode, issuingStateCode, licenceTypeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceIssuerPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    issuerName: ").append(toIndentedString(issuerName)).append("\n");
        sb.append("    issuingCountryCode: ").append(toIndentedString(issuingCountryCode)).append("\n");
        sb.append("    issuingStateCode: ").append(toIndentedString(issuingStateCode)).append("\n");
        sb.append("    licenceTypeId: ").append(toIndentedString(licenceTypeId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

