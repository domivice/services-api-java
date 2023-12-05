package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.CertificationStatus;
import org.domivice.services.web.api.rest.models.Media;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Carries the service category certification
 */

@Schema(name = "Certification", description = "Carries the service category certification")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class Certification {

  private UUID id;

  private UUID serviceProviderId;

  private String certificateTitle;

  private String certificateHolder;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateIssued;

  private String issuer;

  private Media document;

  @Valid
  private List<UUID> serviceCategoryIds;

  private CertificationStatus status;

  /**
   * Default constructor
   * @deprecated Use {@link Certification#Certification(UUID, UUID, String, String, LocalDate, String, CertificationStatus)}
   */
  @Deprecated
  public Certification() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Certification(UUID id, UUID serviceProviderId, String certificateTitle, String certificateHolder, LocalDate dateIssued, String issuer, CertificationStatus status) {
    this.id = id;
    this.serviceProviderId = serviceProviderId;
    this.certificateTitle = certificateTitle;
    this.certificateHolder = certificateHolder;
    this.dateIssued = dateIssued;
    this.issuer = issuer;
    this.status = status;
  }

  public Certification id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The certification id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The certification id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Certification serviceProviderId(UUID serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
    return this;
  }

  /**
   * The service provider id
   * @return serviceProviderId
  */
  @NotNull @Valid 
  @Schema(name = "serviceProviderId", description = "The service provider id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceProviderId")
  public UUID getServiceProviderId() {
    return serviceProviderId;
  }

  public void setServiceProviderId(UUID serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
  }

  public Certification certificateTitle(String certificateTitle) {
    this.certificateTitle = certificateTitle;
    return this;
  }

  /**
   * The certificate title
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

  public Certification certificateHolder(String certificateHolder) {
    this.certificateHolder = certificateHolder;
    return this;
  }

  /**
   * The certificate holder
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

  public Certification dateIssued(LocalDate dateIssued) {
    this.dateIssued = dateIssued;
    return this;
  }

  /**
   * The date in which the certificate was issued
   * @return dateIssued
  */
  @NotNull @Valid 
  @Schema(name = "dateIssued", description = "The date in which the certificate was issued", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateIssued")
  public LocalDate getDateIssued() {
    return dateIssued;
  }

  public void setDateIssued(LocalDate dateIssued) {
    this.dateIssued = dateIssued;
  }

  public Certification issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * The issuing authority 
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

  public Certification document(Media document) {
    this.document = document;
    return this;
  }

  /**
   * Get document
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

  public Certification serviceCategoryIds(List<UUID> serviceCategoryIds) {
    this.serviceCategoryIds = serviceCategoryIds;
    return this;
  }

  public Certification addServiceCategoryIdsItem(UUID serviceCategoryIdsItem) {
    if (this.serviceCategoryIds == null) {
      this.serviceCategoryIds = new ArrayList<>();
    }
    this.serviceCategoryIds.add(serviceCategoryIdsItem);
    return this;
  }

  /**
   * The service category ids for which this certification is relevant
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

  public Certification status(CertificationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public CertificationStatus getStatus() {
    return status;
  }

  public void setStatus(CertificationStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Certification certification = (Certification) o;
    return Objects.equals(this.id, certification.id) &&
        Objects.equals(this.serviceProviderId, certification.serviceProviderId) &&
        Objects.equals(this.certificateTitle, certification.certificateTitle) &&
        Objects.equals(this.certificateHolder, certification.certificateHolder) &&
        Objects.equals(this.dateIssued, certification.dateIssued) &&
        Objects.equals(this.issuer, certification.issuer) &&
        Objects.equals(this.document, certification.document) &&
        Objects.equals(this.serviceCategoryIds, certification.serviceCategoryIds) &&
        Objects.equals(this.status, certification.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, serviceProviderId, certificateTitle, certificateHolder, dateIssued, issuer, document, serviceCategoryIds, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Certification {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
    sb.append("    certificateTitle: ").append(toIndentedString(certificateTitle)).append("\n");
    sb.append("    certificateHolder: ").append(toIndentedString(certificateHolder)).append("\n");
    sb.append("    dateIssued: ").append(toIndentedString(dateIssued)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    serviceCategoryIds: ").append(toIndentedString(serviceCategoryIds)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

