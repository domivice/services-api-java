package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.LicenceStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The service licence
 */

@Schema(name = "LicencePatch", description = "The service licence")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class LicencePatch {

  private String licenceNumber;

  private LicenceStatus status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate validUntil;

  private UUID serviceProviderId;

  private UUID licenceRequirementId;

  private UUID licenceIssuerId;

  private UUID id;

  /**
   * Default constructor
   * @deprecated Use {@link LicencePatch#LicencePatch(UUID)}
   */
  @Deprecated
  public LicencePatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LicencePatch(UUID id) {
    this.id = id;
  }

  public LicencePatch licenceNumber(String licenceNumber) {
    this.licenceNumber = licenceNumber;
    return this;
  }

  /**
   * The licence number
   * @return licenceNumber
  */
  
  @Schema(name = "licenceNumber", description = "The licence number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("licenceNumber")
  public String getLicenceNumber() {
    return licenceNumber;
  }

  public void setLicenceNumber(String licenceNumber) {
    this.licenceNumber = licenceNumber;
  }

  public LicencePatch status(LicenceStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public LicenceStatus getStatus() {
    return status;
  }

  public void setStatus(LicenceStatus status) {
    this.status = status;
  }

  public LicencePatch validUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * The date at which the licence will no longer be valid
   * @return validUntil
  */
  @Valid 
  @Schema(name = "validUntil", description = "The date at which the licence will no longer be valid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validUntil")
  public LocalDate getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
  }

  public LicencePatch serviceProviderId(UUID serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
    return this;
  }

  /**
   * The service provider id
   * @return serviceProviderId
  */
  @Valid 
  @Schema(name = "serviceProviderId", description = "The service provider id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serviceProviderId")
  public UUID getServiceProviderId() {
    return serviceProviderId;
  }

  public void setServiceProviderId(UUID serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
  }

  public LicencePatch licenceRequirementId(UUID licenceRequirementId) {
    this.licenceRequirementId = licenceRequirementId;
    return this;
  }

  /**
   * The licence requirement id
   * @return licenceRequirementId
  */
  @Valid 
  @Schema(name = "licenceRequirementId", description = "The licence requirement id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("licenceRequirementId")
  public UUID getLicenceRequirementId() {
    return licenceRequirementId;
  }

  public void setLicenceRequirementId(UUID licenceRequirementId) {
    this.licenceRequirementId = licenceRequirementId;
  }

  public LicencePatch licenceIssuerId(UUID licenceIssuerId) {
    this.licenceIssuerId = licenceIssuerId;
    return this;
  }

  /**
   * The licence issuer id
   * @return licenceIssuerId
  */
  @Valid 
  @Schema(name = "licenceIssuerId", description = "The licence issuer id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("licenceIssuerId")
  public UUID getLicenceIssuerId() {
    return licenceIssuerId;
  }

  public void setLicenceIssuerId(UUID licenceIssuerId) {
    this.licenceIssuerId = licenceIssuerId;
  }

  public LicencePatch id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The licence id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The licence id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LicencePatch licencePatch = (LicencePatch) o;
    return Objects.equals(this.licenceNumber, licencePatch.licenceNumber) &&
        Objects.equals(this.status, licencePatch.status) &&
        Objects.equals(this.validUntil, licencePatch.validUntil) &&
        Objects.equals(this.serviceProviderId, licencePatch.serviceProviderId) &&
        Objects.equals(this.licenceRequirementId, licencePatch.licenceRequirementId) &&
        Objects.equals(this.licenceIssuerId, licencePatch.licenceIssuerId) &&
        Objects.equals(this.id, licencePatch.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenceNumber, status, validUntil, serviceProviderId, licenceRequirementId, licenceIssuerId, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicencePatch {\n");
    sb.append("    licenceNumber: ").append(toIndentedString(licenceNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
    sb.append("    licenceRequirementId: ").append(toIndentedString(licenceRequirementId)).append("\n");
    sb.append("    licenceIssuerId: ").append(toIndentedString(licenceIssuerId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

