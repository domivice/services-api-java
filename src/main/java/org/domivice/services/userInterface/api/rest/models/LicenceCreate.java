package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * The service licence
 */

@Schema(name = "LicenceCreate", description = "The service licence")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class LicenceCreate {

    private String licenceNumber;

    private LicenceStatus status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validUntil;

    private UUID serviceProviderId;

    private UUID licenceRequirementId;

    private UUID licenceIssuerId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceCreate#LicenceCreate(String, LicenceStatus, LocalDate, UUID, UUID, UUID)}
     */
    @Deprecated
    public LicenceCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceCreate(String licenceNumber, LicenceStatus status, LocalDate validUntil, UUID serviceProviderId, UUID licenceRequirementId, UUID licenceIssuerId) {
        this.licenceNumber = licenceNumber;
        this.status = status;
        this.validUntil = validUntil;
        this.serviceProviderId = serviceProviderId;
        this.licenceRequirementId = licenceRequirementId;
        this.licenceIssuerId = licenceIssuerId;
    }

    public LicenceCreate licenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        return this;
    }

    /**
     * The licence number
     *
     * @return licenceNumber
     */
    @NotNull
    @Schema(name = "licenceNumber", description = "The licence number", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceNumber")
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public LicenceCreate status(LicenceStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @NotNull
    @Valid
    @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("status")
    public LicenceStatus getStatus() {
        return status;
    }

    public void setStatus(LicenceStatus status) {
        this.status = status;
    }

    public LicenceCreate validUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    /**
     * The date at which the licence will no longer be valid
     *
     * @return validUntil
     */
    @NotNull
    @Valid
    @Schema(name = "validUntil", description = "The date at which the licence will no longer be valid", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("validUntil")
    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public LicenceCreate serviceProviderId(UUID serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
        return this;
    }

    /**
     * The service provider id
     *
     * @return serviceProviderId
     */
    @NotNull
    @Valid
    @Schema(name = "serviceProviderId", description = "The service provider id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceProviderId")
    public UUID getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(UUID serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public LicenceCreate licenceRequirementId(UUID licenceRequirementId) {
        this.licenceRequirementId = licenceRequirementId;
        return this;
    }

    /**
     * The licence requirement id
     *
     * @return licenceRequirementId
     */
    @NotNull
    @Valid
    @Schema(name = "licenceRequirementId", description = "The licence requirement id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceRequirementId")
    public UUID getLicenceRequirementId() {
        return licenceRequirementId;
    }

    public void setLicenceRequirementId(UUID licenceRequirementId) {
        this.licenceRequirementId = licenceRequirementId;
    }

    public LicenceCreate licenceIssuerId(UUID licenceIssuerId) {
        this.licenceIssuerId = licenceIssuerId;
        return this;
    }

    /**
     * The licence issuer id
     *
     * @return licenceIssuerId
     */
    @NotNull
    @Valid
    @Schema(name = "licenceIssuerId", description = "The licence issuer id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceIssuerId")
    public UUID getLicenceIssuerId() {
        return licenceIssuerId;
    }

    public void setLicenceIssuerId(UUID licenceIssuerId) {
        this.licenceIssuerId = licenceIssuerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LicenceCreate licenceCreate = (LicenceCreate) o;
        return Objects.equals(this.licenceNumber, licenceCreate.licenceNumber) &&
                Objects.equals(this.status, licenceCreate.status) &&
                Objects.equals(this.validUntil, licenceCreate.validUntil) &&
                Objects.equals(this.serviceProviderId, licenceCreate.serviceProviderId) &&
                Objects.equals(this.licenceRequirementId, licenceCreate.licenceRequirementId) &&
                Objects.equals(this.licenceIssuerId, licenceCreate.licenceIssuerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceNumber, status, validUntil, serviceProviderId, licenceRequirementId, licenceIssuerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceCreate {\n");
        sb.append("    licenceNumber: ").append(toIndentedString(licenceNumber)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
        sb.append("    licenceRequirementId: ").append(toIndentedString(licenceRequirementId)).append("\n");
        sb.append("    licenceIssuerId: ").append(toIndentedString(licenceIssuerId)).append("\n");
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

