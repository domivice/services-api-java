package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.DocumentRequirement;
import org.domivice.services.web.api.rest.models.DocumentStatus;
import org.domivice.services.web.api.rest.models.DocumentType;
import org.domivice.services.web.api.rest.models.Media;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The document 
 */

@Schema(name = "Document", description = "The document ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class Document {

  private UUID id;

  private UUID serviceProviderId;

  private DocumentRequirement documentRequirement;

  private DocumentType documentType;

  private Media document;

  private DocumentStatus status;

  /**
   * Default constructor
   * @deprecated Use {@link Document#Document(UUID, UUID, DocumentRequirement, DocumentType, Media, DocumentStatus)}
   */
  @Deprecated
  public Document() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Document(UUID id, UUID serviceProviderId, DocumentRequirement documentRequirement, DocumentType documentType, Media document, DocumentStatus status) {
    this.id = id;
    this.serviceProviderId = serviceProviderId;
    this.documentRequirement = documentRequirement;
    this.documentType = documentType;
    this.document = document;
    this.status = status;
  }

  public Document id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The document id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The document id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Document serviceProviderId(UUID serviceProviderId) {
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

  public Document documentRequirement(DocumentRequirement documentRequirement) {
    this.documentRequirement = documentRequirement;
    return this;
  }

  /**
   * Get documentRequirement
   * @return documentRequirement
  */
  @NotNull @Valid 
  @Schema(name = "documentRequirement", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("documentRequirement")
  public DocumentRequirement getDocumentRequirement() {
    return documentRequirement;
  }

  public void setDocumentRequirement(DocumentRequirement documentRequirement) {
    this.documentRequirement = documentRequirement;
  }

  public Document documentType(DocumentType documentType) {
    this.documentType = documentType;
    return this;
  }

  /**
   * Get documentType
   * @return documentType
  */
  @NotNull @Valid 
  @Schema(name = "documentType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("documentType")
  public DocumentType getDocumentType() {
    return documentType;
  }

  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }

  public Document document(Media document) {
    this.document = document;
    return this;
  }

  /**
   * Get document
   * @return document
  */
  @NotNull @Valid 
  @Schema(name = "document", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("document")
  public Media getDocument() {
    return document;
  }

  public void setDocument(Media document) {
    this.document = document;
  }

  public Document status(DocumentStatus status) {
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
  public DocumentStatus getStatus() {
    return status;
  }

  public void setStatus(DocumentStatus status) {
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
    Document document = (Document) o;
    return Objects.equals(this.id, document.id) &&
        Objects.equals(this.serviceProviderId, document.serviceProviderId) &&
        Objects.equals(this.documentRequirement, document.documentRequirement) &&
        Objects.equals(this.documentType, document.documentType) &&
        Objects.equals(this.document, document.document) &&
        Objects.equals(this.status, document.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, serviceProviderId, documentRequirement, documentType, document, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
    sb.append("    documentRequirement: ").append(toIndentedString(documentRequirement)).append("\n");
    sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
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

