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

@Schema(name = "LicenceIssuer", description = "Carries license type information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class LicenceIssuer {

    private UUID id;

    private State issuingState;

    private Country issuingCountry;

    private String issuerName;

    private LicenceType licenceType;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceIssuer#LicenceIssuer(UUID, State, Country, String, LicenceType)}
     */
    @Deprecated
    public LicenceIssuer() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceIssuer(UUID id, State issuingState, Country issuingCountry, String issuerName, LicenceType licenceType) {
        this.id = id;
        this.issuingState = issuingState;
        this.issuingCountry = issuingCountry;
        this.issuerName = issuerName;
        this.licenceType = licenceType;
    }

    public LicenceIssuer id(UUID id) {
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

    public LicenceIssuer issuingState(State issuingState) {
        this.issuingState = issuingState;
        return this;
    }

    /**
     * Get issuingState
     *
     * @return issuingState
     */
    @NotNull
    @Valid
    @Schema(name = "issuingState", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingState")
    public State getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(State issuingState) {
        this.issuingState = issuingState;
    }

    public LicenceIssuer issuingCountry(Country issuingCountry) {
        this.issuingCountry = issuingCountry;
        return this;
    }

    /**
     * Get issuingCountry
     *
     * @return issuingCountry
     */
    @NotNull
    @Valid
    @Schema(name = "issuingCountry", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingCountry")
    public Country getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(Country issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public LicenceIssuer issuerName(String issuerName) {
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

    public LicenceIssuer licenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
        return this;
    }

    /**
     * Get licenceType
     *
     * @return licenceType
     */
    @NotNull
    @Valid
    @Schema(name = "licenceType", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceType")
    public LicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LicenceIssuer licenceIssuer = (LicenceIssuer) o;
        return Objects.equals(this.id, licenceIssuer.id) &&
                Objects.equals(this.issuingState, licenceIssuer.issuingState) &&
                Objects.equals(this.issuingCountry, licenceIssuer.issuingCountry) &&
                Objects.equals(this.issuerName, licenceIssuer.issuerName) &&
                Objects.equals(this.licenceType, licenceIssuer.licenceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issuingState, issuingCountry, issuerName, licenceType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceIssuer {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    issuingState: ").append(toIndentedString(issuingState)).append("\n");
        sb.append("    issuingCountry: ").append(toIndentedString(issuingCountry)).append("\n");
        sb.append("    issuerName: ").append(toIndentedString(issuerName)).append("\n");
        sb.append("    licenceType: ").append(toIndentedString(licenceType)).append("\n");
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

