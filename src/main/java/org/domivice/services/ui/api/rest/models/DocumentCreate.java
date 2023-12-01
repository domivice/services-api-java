package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * The document
 */

@Schema(name = "DocumentCreate", description = "The document ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class DocumentCreate {

    private UUID serviceProviderId;

    private DocumentStatus status;

    private String documentRequirementId;

    private String documentTypeId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentCreate#DocumentCreate(UUID, DocumentStatus, String, String)}
     */
    @Deprecated
    public DocumentCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentCreate(UUID serviceProviderId, DocumentStatus status, String documentRequirementId, String documentTypeId) {
        this.serviceProviderId = serviceProviderId;
        this.status = status;
        this.documentRequirementId = documentRequirementId;
        this.documentTypeId = documentTypeId;
    }

    public DocumentCreate serviceProviderId(UUID serviceProviderId) {
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

    public DocumentCreate status(DocumentStatus status) {
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
    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public DocumentCreate documentRequirementId(String documentRequirementId) {
        this.documentRequirementId = documentRequirementId;
        return this;
    }

    /**
     * The document requirement id
     *
     * @return documentRequirementId
     */
    @NotNull
    @Schema(name = "documentRequirementId", description = "The document requirement id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documentRequirementId")
    public String getDocumentRequirementId() {
        return documentRequirementId;
    }

    public void setDocumentRequirementId(String documentRequirementId) {
        this.documentRequirementId = documentRequirementId;
    }

    public DocumentCreate documentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
        return this;
    }

    /**
     * The document type id
     *
     * @return documentTypeId
     */
    @NotNull
    @Schema(name = "documentTypeId", description = "The document type id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documentTypeId")
    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentCreate documentCreate = (DocumentCreate) o;
        return Objects.equals(this.serviceProviderId, documentCreate.serviceProviderId) &&
                Objects.equals(this.status, documentCreate.status) &&
                Objects.equals(this.documentRequirementId, documentCreate.documentRequirementId) &&
                Objects.equals(this.documentTypeId, documentCreate.documentTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceProviderId, status, documentRequirementId, documentTypeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentCreate {\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    documentRequirementId: ").append(toIndentedString(documentRequirementId)).append("\n");
        sb.append("    documentTypeId: ").append(toIndentedString(documentTypeId)).append("\n");
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

