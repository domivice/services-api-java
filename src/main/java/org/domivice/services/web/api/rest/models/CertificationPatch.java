package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

@Schema(name = "CertificationPatch", description = "Carries the service category certification")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class CertificationPatch {

  private UUID id;

  private String certificateTitle;

  private String certificateHolder;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateIssued;

  private String issuer;

  @Valid
  private List<UUID> serviceCategoryIds;

  /**
   * Default constructor
   * @deprecated Use {@link CertificationPatch#CertificationPatch(UUID)}
   */
  @Deprecated
  public CertificationPatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CertificationPatch(UUID id) {
    this.id = id;
  }

  public CertificationPatch id(UUID id) {
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

  public CertificationPatch certificateTitle(String certificateTitle) {
    this.certificateTitle = certificateTitle;
    return this;
  }

  /**
   * The certificate title
   * @return certificateTitle
  */
  
  @Schema(name = "certificateTitle", description = "The certificate title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("certificateTitle")
  public String getCertificateTitle() {
    return certificateTitle;
  }

  public void setCertificateTitle(String certificateTitle) {
    this.certificateTitle = certificateTitle;
  }

  public CertificationPatch certificateHolder(String certificateHolder) {
    this.certificateHolder = certificateHolder;
    return this;
  }

  /**
   * The certificate holder
   * @return certificateHolder
  */
  
  @Schema(name = "certificateHolder", description = "The certificate holder", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("certificateHolder")
  public String getCertificateHolder() {
    return certificateHolder;
  }

  public void setCertificateHolder(String certificateHolder) {
    this.certificateHolder = certificateHolder;
  }

  public CertificationPatch dateIssued(LocalDate dateIssued) {
    this.dateIssued = dateIssued;
    return this;
  }

  /**
   * The date in which the certificate was issued
   * @return dateIssued
  */
  @Valid 
  @Schema(name = "dateIssued", description = "The date in which the certificate was issued", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateIssued")
  public LocalDate getDateIssued() {
    return dateIssued;
  }

  public void setDateIssued(LocalDate dateIssued) {
    this.dateIssued = dateIssued;
  }

  public CertificationPatch issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * The issuing authority 
   * @return issuer
  */
  
  @Schema(name = "issuer", description = "The issuing authority ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issuer")
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public CertificationPatch serviceCategoryIds(List<UUID> serviceCategoryIds) {
    this.serviceCategoryIds = serviceCategoryIds;
    return this;
  }

  public CertificationPatch addServiceCategoryIdsItem(UUID serviceCategoryIdsItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificationPatch certificationPatch = (CertificationPatch) o;
    return Objects.equals(this.id, certificationPatch.id) &&
        Objects.equals(this.certificateTitle, certificationPatch.certificateTitle) &&
        Objects.equals(this.certificateHolder, certificationPatch.certificateHolder) &&
        Objects.equals(this.dateIssued, certificationPatch.dateIssued) &&
        Objects.equals(this.issuer, certificationPatch.issuer) &&
        Objects.equals(this.serviceCategoryIds, certificationPatch.serviceCategoryIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, certificateTitle, certificateHolder, dateIssued, issuer, serviceCategoryIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificationPatch {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

