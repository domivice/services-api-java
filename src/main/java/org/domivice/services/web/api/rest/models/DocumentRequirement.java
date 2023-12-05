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
import org.domivice.services.web.api.rest.models.Country;
import org.domivice.services.web.api.rest.models.DocumentRequirementStatus;
import org.domivice.services.web.api.rest.models.DocumentType;
import org.domivice.services.web.api.rest.models.State;
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

@Schema(name = "DocumentRequirement", description = "The document requirement as specified by countries or states")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class DocumentRequirement {

  private UUID id;

  private String name;

  @Valid
  private List<@Valid DocumentType> documentTypes;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  private DocumentRequirementStatus status;

  private Country requiringCountry;

  private State requiringState;

  /**
   * Default constructor
   * @deprecated Use {@link DocumentRequirement#DocumentRequirement(UUID, String, OffsetDateTime, DocumentRequirementStatus, Country, State)}
   */
  @Deprecated
  public DocumentRequirement() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DocumentRequirement(UUID id, String name, OffsetDateTime startDate, DocumentRequirementStatus status, Country requiringCountry, State requiringState) {
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.status = status;
    this.requiringCountry = requiringCountry;
    this.requiringState = requiringState;
  }

  public DocumentRequirement id(UUID id) {
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

  public DocumentRequirement name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The document requirement name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The document requirement name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DocumentRequirement documentTypes(List<@Valid DocumentType> documentTypes) {
    this.documentTypes = documentTypes;
    return this;
  }

  public DocumentRequirement addDocumentTypesItem(DocumentType documentTypesItem) {
    if (this.documentTypes == null) {
      this.documentTypes = new ArrayList<>();
    }
    this.documentTypes.add(documentTypesItem);
    return this;
  }

  /**
   * The accepted document types
   * @return documentTypes
  */
  @Valid 
  @Schema(name = "documentTypes", description = "The accepted document types", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentTypes")
  public List<@Valid DocumentType> getDocumentTypes() {
    return documentTypes;
  }

  public void setDocumentTypes(List<@Valid DocumentType> documentTypes) {
    this.documentTypes = documentTypes;
  }

  public DocumentRequirement startDate(OffsetDateTime startDate) {
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

  public DocumentRequirement endDate(OffsetDateTime endDate) {
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

  public DocumentRequirement status(DocumentRequirementStatus status) {
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
  public DocumentRequirementStatus getStatus() {
    return status;
  }

  public void setStatus(DocumentRequirementStatus status) {
    this.status = status;
  }

  public DocumentRequirement requiringCountry(Country requiringCountry) {
    this.requiringCountry = requiringCountry;
    return this;
  }

  /**
   * Get requiringCountry
   * @return requiringCountry
  */
  @NotNull @Valid 
  @Schema(name = "requiringCountry", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiringCountry")
  public Country getRequiringCountry() {
    return requiringCountry;
  }

  public void setRequiringCountry(Country requiringCountry) {
    this.requiringCountry = requiringCountry;
  }

  public DocumentRequirement requiringState(State requiringState) {
    this.requiringState = requiringState;
    return this;
  }

  /**
   * Get requiringState
   * @return requiringState
  */
  @NotNull @Valid 
  @Schema(name = "requiringState", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiringState")
  public State getRequiringState() {
    return requiringState;
  }

  public void setRequiringState(State requiringState) {
    this.requiringState = requiringState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentRequirement documentRequirement = (DocumentRequirement) o;
    return Objects.equals(this.id, documentRequirement.id) &&
        Objects.equals(this.name, documentRequirement.name) &&
        Objects.equals(this.documentTypes, documentRequirement.documentTypes) &&
        Objects.equals(this.startDate, documentRequirement.startDate) &&
        Objects.equals(this.endDate, documentRequirement.endDate) &&
        Objects.equals(this.status, documentRequirement.status) &&
        Objects.equals(this.requiringCountry, documentRequirement.requiringCountry) &&
        Objects.equals(this.requiringState, documentRequirement.requiringState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, documentTypes, startDate, endDate, status, requiringCountry, requiringState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentRequirement {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    documentTypes: ").append(toIndentedString(documentTypes)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    requiringCountry: ").append(toIndentedString(requiringCountry)).append("\n");
    sb.append("    requiringState: ").append(toIndentedString(requiringState)).append("\n");
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

