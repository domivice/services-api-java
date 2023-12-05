package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
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
 * The service category licence requirements
 */

@Schema(name = "LicenceRequirementCreate", description = "The service category licence requirements")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class LicenceRequirementCreate {

  private UUID serviceCategoryId;

  private String countryCode;

  @Valid
  private List<UUID> licenceIssuerIds = new ArrayList<>();

  private UUID licenceTypeId;

  private String stateCode;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  /**
   * Default constructor
   * @deprecated Use {@link LicenceRequirementCreate#LicenceRequirementCreate(UUID, String, List<UUID>, UUID, String, OffsetDateTime)}
   */
  @Deprecated
  public LicenceRequirementCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LicenceRequirementCreate(UUID serviceCategoryId, String countryCode, List<UUID> licenceIssuerIds, UUID licenceTypeId, String stateCode, OffsetDateTime startDate) {
    this.serviceCategoryId = serviceCategoryId;
    this.countryCode = countryCode;
    this.licenceIssuerIds = licenceIssuerIds;
    this.licenceTypeId = licenceTypeId;
    this.stateCode = stateCode;
    this.startDate = startDate;
  }

  public LicenceRequirementCreate serviceCategoryId(UUID serviceCategoryId) {
    this.serviceCategoryId = serviceCategoryId;
    return this;
  }

  /**
   * The service category id
   * @return serviceCategoryId
  */
  @NotNull @Valid 
  @Schema(name = "serviceCategoryId", description = "The service category id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceCategoryId")
  public UUID getServiceCategoryId() {
    return serviceCategoryId;
  }

  public void setServiceCategoryId(UUID serviceCategoryId) {
    this.serviceCategoryId = serviceCategoryId;
  }

  public LicenceRequirementCreate countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * The requiring country code
   * @return countryCode
  */
  @NotNull 
  @Schema(name = "countryCode", description = "The requiring country code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("countryCode")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public LicenceRequirementCreate licenceIssuerIds(List<UUID> licenceIssuerIds) {
    this.licenceIssuerIds = licenceIssuerIds;
    return this;
  }

  public LicenceRequirementCreate addLicenceIssuerIdsItem(UUID licenceIssuerIdsItem) {
    if (this.licenceIssuerIds == null) {
      this.licenceIssuerIds = new ArrayList<>();
    }
    this.licenceIssuerIds.add(licenceIssuerIdsItem);
    return this;
  }

  /**
   * The accepted licence issuer ids
   * @return licenceIssuerIds
  */
  @NotNull @Valid 
  @Schema(name = "licenceIssuerIds", description = "The accepted licence issuer ids", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("licenceIssuerIds")
  public List<UUID> getLicenceIssuerIds() {
    return licenceIssuerIds;
  }

  public void setLicenceIssuerIds(List<UUID> licenceIssuerIds) {
    this.licenceIssuerIds = licenceIssuerIds;
  }

  public LicenceRequirementCreate licenceTypeId(UUID licenceTypeId) {
    this.licenceTypeId = licenceTypeId;
    return this;
  }

  /**
   * The licence type id
   * @return licenceTypeId
  */
  @NotNull @Valid 
  @Schema(name = "licenceTypeId", description = "The licence type id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("licenceTypeId")
  public UUID getLicenceTypeId() {
    return licenceTypeId;
  }

  public void setLicenceTypeId(UUID licenceTypeId) {
    this.licenceTypeId = licenceTypeId;
  }

  public LicenceRequirementCreate stateCode(String stateCode) {
    this.stateCode = stateCode;
    return this;
  }

  /**
   * The requiring state
   * @return stateCode
  */
  @NotNull 
  @Schema(name = "stateCode", description = "The requiring state", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stateCode")
  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public LicenceRequirementCreate startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The requirement start date
   * @return startDate
  */
  @NotNull @Valid 
  @Schema(name = "startDate", description = "The requirement start date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public LicenceRequirementCreate endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The requirement end date
   * @return endDate
  */
  @Valid 
  @Schema(name = "endDate", description = "The requirement end date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LicenceRequirementCreate licenceRequirementCreate = (LicenceRequirementCreate) o;
    return Objects.equals(this.serviceCategoryId, licenceRequirementCreate.serviceCategoryId) &&
        Objects.equals(this.countryCode, licenceRequirementCreate.countryCode) &&
        Objects.equals(this.licenceIssuerIds, licenceRequirementCreate.licenceIssuerIds) &&
        Objects.equals(this.licenceTypeId, licenceRequirementCreate.licenceTypeId) &&
        Objects.equals(this.stateCode, licenceRequirementCreate.stateCode) &&
        Objects.equals(this.startDate, licenceRequirementCreate.startDate) &&
        Objects.equals(this.endDate, licenceRequirementCreate.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCategoryId, countryCode, licenceIssuerIds, licenceTypeId, stateCode, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicenceRequirementCreate {\n");
    sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    licenceIssuerIds: ").append(toIndentedString(licenceIssuerIds)).append("\n");
    sb.append("    licenceTypeId: ").append(toIndentedString(licenceTypeId)).append("\n");
    sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

