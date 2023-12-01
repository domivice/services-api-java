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

@Schema(name = "DocumentPatch", description = "The document ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class DocumentPatch {

    private UUID id;

    private UUID serviceProviderId;

    private DocumentStatus status;

    private String documentRequirementId;

    private String documentTypeId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentPatch#DocumentPatch(UUID)}
     */
    @Deprecated
    public DocumentPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentPatch(UUID id) {
        this.id = id;
    }

    public DocumentPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The document id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The document id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentPatch serviceProviderId(UUID serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
        return this;
    }

    /**
     * The service provider id
     *
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

    public DocumentPatch status(DocumentStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @Valid
    @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public DocumentPatch documentRequirementId(String documentRequirementId) {
        this.documentRequirementId = documentRequirementId;
        return this;
    }

    /**
     * The document requirement id
     *
     * @return documentRequirementId
     */

    @Schema(name = "documentRequirementId", description = "The document requirement id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("documentRequirementId")
    public String getDocumentRequirementId() {
        return documentRequirementId;
    }

    public void setDocumentRequirementId(String documentRequirementId) {
        this.documentRequirementId = documentRequirementId;
    }

    public DocumentPatch documentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
        return this;
    }

    /**
     * The document type id
     *
     * @return documentTypeId
     */

    @Schema(name = "documentTypeId", description = "The document type id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
        DocumentPatch documentPatch = (DocumentPatch) o;
        return Objects.equals(this.id, documentPatch.id) &&
                Objects.equals(this.serviceProviderId, documentPatch.serviceProviderId) &&
                Objects.equals(this.status, documentPatch.status) &&
                Objects.equals(this.documentRequirementId, documentPatch.documentRequirementId) &&
                Objects.equals(this.documentTypeId, documentPatch.documentTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceProviderId, status, documentRequirementId, documentTypeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

