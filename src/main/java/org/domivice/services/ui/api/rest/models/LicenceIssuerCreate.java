package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * Carries license type information
 */

@Schema(name = "LicenceIssuerCreate", description = "Carries license type information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class LicenceIssuerCreate {

    private String issuerName;

    private String issuingCountryCode;

    private String issuingStateCode;

    private UUID licenceTypeId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceIssuerCreate#LicenceIssuerCreate(String, String, String, UUID)}
     */
    @Deprecated
    public LicenceIssuerCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceIssuerCreate(String issuerName, String issuingCountryCode, String issuingStateCode, UUID licenceTypeId) {
        this.issuerName = issuerName;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
        this.licenceTypeId = licenceTypeId;
    }

    public LicenceIssuerCreate issuerName(String issuerName) {
        this.issuerName = issuerName;
        return this;
    }

    /**
     * The licence issuer e.g. Société de l'assurance automobile du Québec (SAAQ)
     *
     * @return issuerName
     */
    @NotNull
    @Schema(name = "issuerName", description = "The licence issuer e.g. Société de l'assurance automobile du Québec (SAAQ)", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuerName")
    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public LicenceIssuerCreate issuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
        return this;
    }

    /**
     * The issuing Country
     *
     * @return issuingCountryCode
     */
    @NotNull
    @Schema(name = "issuingCountryCode", description = "The issuing Country", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingCountryCode")
    public String getIssuingCountryCode() {
        return issuingCountryCode;
    }

    public void setIssuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
    }

    public LicenceIssuerCreate issuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
        return this;
    }

    /**
     * The licence issuing state
     *
     * @return issuingStateCode
     */
    @NotNull
    @Schema(name = "issuingStateCode", description = "The licence issuing state", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingStateCode")
    public String getIssuingStateCode() {
        return issuingStateCode;
    }

    public void setIssuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
    }

    public LicenceIssuerCreate licenceTypeId(UUID licenceTypeId) {
        this.licenceTypeId = licenceTypeId;
        return this;
    }

    /**
     * The licence type this issuer can issue
     *
     * @return licenceTypeId
     */
    @NotNull
    @Valid
    @Schema(name = "licenceTypeId", description = "The licence type this issuer can issue", requiredMode = Schema.RequiredMode.REQUIRED)
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
        LicenceIssuerCreate licenceIssuerCreate = (LicenceIssuerCreate) o;
        return Objects.equals(this.issuerName, licenceIssuerCreate.issuerName) &&
                Objects.equals(this.issuingCountryCode, licenceIssuerCreate.issuingCountryCode) &&
                Objects.equals(this.issuingStateCode, licenceIssuerCreate.issuingStateCode) &&
                Objects.equals(this.licenceTypeId, licenceIssuerCreate.licenceTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuerName, issuingCountryCode, issuingStateCode, licenceTypeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceIssuerCreate {\n");
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

