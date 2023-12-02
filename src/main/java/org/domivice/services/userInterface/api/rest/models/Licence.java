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

@Schema(name = "Licence", description = "The service licence")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class Licence {

    private UUID id;

    private String licenceNumber;

    private LicenceStatus status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validUntil;

    private UUID serviceProviderId;

    private LicenceRequirement licenceRequirement;

    private LicenceIssuer licenceIssuer;

    private Media document;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Licence#Licence(UUID, String, LicenceStatus, LocalDate, UUID, LicenceRequirement, LicenceIssuer)}
     */
    @Deprecated
    public Licence() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Licence(UUID id, String licenceNumber, LicenceStatus status, LocalDate validUntil, UUID serviceProviderId, LicenceRequirement licenceRequirement, LicenceIssuer licenceIssuer) {
        this.id = id;
        this.licenceNumber = licenceNumber;
        this.status = status;
        this.validUntil = validUntil;
        this.serviceProviderId = serviceProviderId;
        this.licenceRequirement = licenceRequirement;
        this.licenceIssuer = licenceIssuer;
    }

    public Licence id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The service licence id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The service licence id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Licence licenceNumber(String licenceNumber) {
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

    public Licence status(LicenceStatus status) {
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

    public Licence validUntil(LocalDate validUntil) {
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

    public Licence serviceProviderId(UUID serviceProviderId) {
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

    public Licence licenceRequirement(LicenceRequirement licenceRequirement) {
        this.licenceRequirement = licenceRequirement;
        return this;
    }

    /**
     * Get licenceRequirement
     *
     * @return licenceRequirement
     */
    @NotNull
    @Valid
    @Schema(name = "licenceRequirement", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceRequirement")
    public LicenceRequirement getLicenceRequirement() {
        return licenceRequirement;
    }

    public void setLicenceRequirement(LicenceRequirement licenceRequirement) {
        this.licenceRequirement = licenceRequirement;
    }

    public Licence licenceIssuer(LicenceIssuer licenceIssuer) {
        this.licenceIssuer = licenceIssuer;
        return this;
    }

    /**
     * Get licenceIssuer
     *
     * @return licenceIssuer
     */
    @NotNull
    @Valid
    @Schema(name = "licenceIssuer", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceIssuer")
    public LicenceIssuer getLicenceIssuer() {
        return licenceIssuer;
    }

    public void setLicenceIssuer(LicenceIssuer licenceIssuer) {
        this.licenceIssuer = licenceIssuer;
    }

    public Licence document(Media document) {
        this.document = document;
        return this;
    }

    /**
     * Get document
     *
     * @return document
     */
    @Valid
    @Schema(name = "document", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("document")
    public Media getDocument() {
        return document;
    }

    public void setDocument(Media document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Licence licence = (Licence) o;
        return Objects.equals(this.id, licence.id) &&
                Objects.equals(this.licenceNumber, licence.licenceNumber) &&
                Objects.equals(this.status, licence.status) &&
                Objects.equals(this.validUntil, licence.validUntil) &&
                Objects.equals(this.serviceProviderId, licence.serviceProviderId) &&
                Objects.equals(this.licenceRequirement, licence.licenceRequirement) &&
                Objects.equals(this.licenceIssuer, licence.licenceIssuer) &&
                Objects.equals(this.document, licence.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenceNumber, status, validUntil, serviceProviderId, licenceRequirement, licenceIssuer, document);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Licence {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    licenceNumber: ").append(toIndentedString(licenceNumber)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
        sb.append("    licenceRequirement: ").append(toIndentedString(licenceRequirement)).append("\n");
        sb.append("    licenceIssuer: ").append(toIndentedString(licenceIssuer)).append("\n");
        sb.append("    document: ").append(toIndentedString(document)).append("\n");
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

