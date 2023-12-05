package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.DocumentRequirementStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The document requirement as specified by countries or states
 */

@Schema(name = "DocumentRequirementPatch", description = "The document requirement as specified by countries or states")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class DocumentRequirementPatch {

  private UUID id;

  private String name;

  private String requiringCountryCode;

  private String requiringStateCode;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  private DocumentRequirementStatus status;

  @Valid
  private List<UUID> documentTypeIds;

  /**
   * Default constructor
   * @deprecated Use {@link DocumentRequirementPatch#DocumentRequirementPatch(UUID)}
   */
  @Deprecated
  public DocumentRequirementPatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DocumentRequirementPatch(UUID id) {
    this.id = id;
  }

  public DocumentRequirementPatch id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The document requirement id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The document requirement id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DocumentRequirementPatch name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The document requirement name
   * @return name
  */
  
  @Schema(name = "name", description = "The document requirement name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DocumentRequirementPatch requiringCountryCode(String requiringCountryCode) {
    this.requiringCountryCode = requiringCountryCode;
    return this;
  }

  /**
   * The requiring country code
   * @return requiringCountryCode
  */
  
  @Schema(name = "requiringCountryCode", description = "The requiring country code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requiringCountryCode")
  public String getRequiringCountryCode() {
    return requiringCountryCode;
  }

  public void setRequiringCountryCode(String requiringCountryCode) {
    this.requiringCountryCode = requiringCountryCode;
  }

  public DocumentRequirementPatch requiringStateCode(String requiringStateCode) {
    this.requiringStateCode = requiringStateCode;
    return this;
  }

  /**
   * The requiring state code
   * @return requiringStateCode
  */
  
  @Schema(name = "requiringStateCode", description = "The requiring state code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requiringStateCode")
  public String getRequiringStateCode() {
    return requiringStateCode;
  }

  public void setRequiringStateCode(String requiringStateCode) {
    this.requiringStateCode = requiringStateCode;
  }

  public DocumentRequirementPatch startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The requirement start date
   * @return startDate
  */
  @Valid 
  @Schema(name = "startDate", description = "The requirement start date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public DocumentRequirementPatch endDate(OffsetDateTime endDate) {
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

  public DocumentRequirementPatch status(DocumentRequirementStatus status) {
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
  public DocumentRequirementStatus getStatus() {
    return status;
  }

  public void setStatus(DocumentRequirementStatus status) {
    this.status = status;
  }

  public DocumentRequirementPatch documentTypeIds(List<UUID> documentTypeIds) {
    this.documentTypeIds = documentTypeIds;
    return this;
  }

  public DocumentRequirementPatch addDocumentTypeIdsItem(UUID documentTypeIdsItem) {
    if (this.documentTypeIds == null) {
      this.documentTypeIds = new ArrayList<>();
    }
    this.documentTypeIds.add(documentTypeIdsItem);
    return this;
  }

  /**
   * The accepted document type ids
   * @return documentTypeIds
  */
  @Valid 
  @Schema(name = "documentTypeIds", description = "The accepted document type ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentTypeIds")
  public List<UUID> getDocumentTypeIds() {
    return documentTypeIds;
  }

  public void setDocumentTypeIds(List<UUID> documentTypeIds) {
    this.documentTypeIds = documentTypeIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentRequirementPatch documentRequirementPatch = (DocumentRequirementPatch) o;
    return Objects.equals(this.id, documentRequirementPatch.id) &&
        Objects.equals(this.name, documentRequirementPatch.name) &&
        Objects.equals(this.requiringCountryCode, documentRequirementPatch.requiringCountryCode) &&
        Objects.equals(this.requiringStateCode, documentRequirementPatch.requiringStateCode) &&
        Objects.equals(this.startDate, documentRequirementPatch.startDate) &&
        Objects.equals(this.endDate, documentRequirementPatch.endDate) &&
        Objects.equals(this.status, documentRequirementPatch.status) &&
        Objects.equals(this.documentTypeIds, documentRequirementPatch.documentTypeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, requiringCountryCode, requiringStateCode, startDate, endDate, status, documentTypeIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentRequirementPatch {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    requiringCountryCode: ").append(toIndentedString(requiringCountryCode)).append("\n");
    sb.append("    requiringStateCode: ").append(toIndentedString(requiringStateCode)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    documentTypeIds: ").append(toIndentedString(documentTypeIds)).append("\n");
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

