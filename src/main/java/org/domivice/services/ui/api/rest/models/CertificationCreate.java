package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Carries the service category certification
 */

@Schema(name = "CertificationCreate", description = "Carries the service category certification")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class CertificationCreate {

    private UUID serviceProviderId;

    private String certificateTitle;

    private String certificateHolder;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateIssued;

    private String issuer;

    @Valid
    private List<UUID> serviceCategoryIds;

    /**
     * Default constructor
     *
     * @deprecated Use {@link CertificationCreate#CertificationCreate(UUID, String, String, LocalDate, String)}
     */
    @Deprecated
    public CertificationCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public CertificationCreate(UUID serviceProviderId, String certificateTitle, String certificateHolder, LocalDate dateIssued, String issuer) {
        this.serviceProviderId = serviceProviderId;
        this.certificateTitle = certificateTitle;
        this.certificateHolder = certificateHolder;
        this.dateIssued = dateIssued;
        this.issuer = issuer;
    }

    public CertificationCreate serviceProviderId(UUID serviceProviderId) {
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

    public CertificationCreate certificateTitle(String certificateTitle) {
        this.certificateTitle = certificateTitle;
        return this;
    }

    /**
     * The certificate title
     *
     * @return certificateTitle
     */
    @NotNull
    @Schema(name = "certificateTitle", description = "The certificate title", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("certificateTitle")
    public String getCertificateTitle() {
        return certificateTitle;
    }

    public void setCertificateTitle(String certificateTitle) {
        this.certificateTitle = certificateTitle;
    }

    public CertificationCreate certificateHolder(String certificateHolder) {
        this.certificateHolder = certificateHolder;
        return this;
    }

    /**
     * The certificate holder
     *
     * @return certificateHolder
     */
    @NotNull
    @Schema(name = "certificateHolder", description = "The certificate holder", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("certificateHolder")
    public String getCertificateHolder() {
        return certificateHolder;
    }

    public void setCertificateHolder(String certificateHolder) {
        this.certificateHolder = certificateHolder;
    }

    public CertificationCreate dateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
        return this;
    }

    /**
     * The date in which the certificate was issued
     *
     * @return dateIssued
     */
    @NotNull
    @Valid
    @Schema(name = "dateIssued", description = "The date in which the certificate was issued", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("dateIssued")
    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public CertificationCreate issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * The issuing authority
     *
     * @return issuer
     */
    @NotNull
    @Schema(name = "issuer", description = "The issuing authority ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuer")
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public CertificationCreate serviceCategoryIds(List<UUID> serviceCategoryIds) {
        this.serviceCategoryIds = serviceCategoryIds;
        return this;
    }

    public CertificationCreate addServiceCategoryIdsItem(UUID serviceCategoryIdsItem) {
        if (this.serviceCategoryIds == null) {
            this.serviceCategoryIds = new ArrayList<>();
        }
        this.serviceCategoryIds.add(serviceCategoryIdsItem);
        return this;
    }

    /**
     * The service category ids for which this certification is relevant
     *
     * @return serviceCategoryIds
     */
    @Valid
    @Schema(name = "serviceCategoryIds", description = "The service category ids for which this certification is relevant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("serviceCategoryIds")
    public List<UUID> getServiceCategoryIds() {
        return serviceCategoryIds;
    }

    public void setServiceCategoryIds(List<UUID> serviceCategoryIds) {
        this.serviceCategoryIds = serviceCategoryIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificationCreate certificationCreate = (CertificationCreate) o;
        return Objects.equals(this.serviceProviderId, certificationCreate.serviceProviderId) &&
                Objects.equals(this.certificateTitle, certificationCreate.certificateTitle) &&
                Objects.equals(this.certificateHolder, certificationCreate.certificateHolder) &&
                Objects.equals(this.dateIssued, certificationCreate.dateIssued) &&
                Objects.equals(this.issuer, certificationCreate.issuer) &&
                Objects.equals(this.serviceCategoryIds, certificationCreate.serviceCategoryIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceProviderId, certificateTitle, certificateHolder, dateIssued, issuer, serviceCategoryIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificationCreate {\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
        sb.append("    certificateTitle: ").append(toIndentedString(certificateTitle)).append("\n");
        sb.append("    certificateHolder: ").append(toIndentedString(certificateHolder)).append("\n");
        sb.append("    dateIssued: ").append(toIndentedString(dateIssued)).append("\n");
        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    serviceCategoryIds: ").append(toIndentedString(serviceCategoryIds)).append("\n");
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

