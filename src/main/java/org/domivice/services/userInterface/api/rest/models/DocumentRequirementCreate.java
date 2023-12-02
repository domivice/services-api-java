package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The document requirement as specified by countries or states
 */

@Schema(name = "DocumentRequirementCreate", description = "The document requirement as specified by countries or states")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class DocumentRequirementCreate {

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
     *
     * @deprecated Use {@link DocumentRequirementCreate#DocumentRequirementCreate(String, String, String, OffsetDateTime, DocumentRequirementStatus)}
     */
    @Deprecated
    public DocumentRequirementCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentRequirementCreate(String name, String requiringCountryCode, String requiringStateCode, OffsetDateTime startDate, DocumentRequirementStatus status) {
        this.name = name;
        this.requiringCountryCode = requiringCountryCode;
        this.requiringStateCode = requiringStateCode;
        this.startDate = startDate;
        this.status = status;
    }

    public DocumentRequirementCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The document requirement name
     *
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

    public DocumentRequirementCreate requiringCountryCode(String requiringCountryCode) {
        this.requiringCountryCode = requiringCountryCode;
        return this;
    }

    /**
     * The requiring country code
     *
     * @return requiringCountryCode
     */
    @NotNull
    @Schema(name = "requiringCountryCode", description = "The requiring country code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("requiringCountryCode")
    public String getRequiringCountryCode() {
        return requiringCountryCode;
    }

    public void setRequiringCountryCode(String requiringCountryCode) {
        this.requiringCountryCode = requiringCountryCode;
    }

    public DocumentRequirementCreate requiringStateCode(String requiringStateCode) {
        this.requiringStateCode = requiringStateCode;
        return this;
    }

    /**
     * The requiring state code
     *
     * @return requiringStateCode
     */
    @NotNull
    @Schema(name = "requiringStateCode", description = "The requiring state code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("requiringStateCode")
    public String getRequiringStateCode() {
        return requiringStateCode;
    }

    public void setRequiringStateCode(String requiringStateCode) {
        this.requiringStateCode = requiringStateCode;
    }

    public DocumentRequirementCreate startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The requirement start date
     *
     * @return startDate
     */
    @NotNull
    @Valid
    @Schema(name = "startDate", description = "The requirement start date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("startDate")
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public DocumentRequirementCreate endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The requirement end date
     *
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

    public DocumentRequirementCreate status(DocumentRequirementStatus status) {
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
    public DocumentRequirementStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentRequirementStatus status) {
        this.status = status;
    }

    public DocumentRequirementCreate documentTypeIds(List<UUID> documentTypeIds) {
        this.documentTypeIds = documentTypeIds;
        return this;
    }

    public DocumentRequirementCreate addDocumentTypeIdsItem(UUID documentTypeIdsItem) {
        if (this.documentTypeIds == null) {
            this.documentTypeIds = new ArrayList<>();
        }
        this.documentTypeIds.add(documentTypeIdsItem);
        return this;
    }

    /**
     * The accepted document type ids
     *
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
        DocumentRequirementCreate documentRequirementCreate = (DocumentRequirementCreate) o;
        return Objects.equals(this.name, documentRequirementCreate.name) &&
                Objects.equals(this.requiringCountryCode, documentRequirementCreate.requiringCountryCode) &&
                Objects.equals(this.requiringStateCode, documentRequirementCreate.requiringStateCode) &&
                Objects.equals(this.startDate, documentRequirementCreate.startDate) &&
                Objects.equals(this.endDate, documentRequirementCreate.endDate) &&
                Objects.equals(this.status, documentRequirementCreate.status) &&
                Objects.equals(this.documentTypeIds, documentRequirementCreate.documentTypeIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, requiringCountryCode, requiringStateCode, startDate, endDate, status, documentTypeIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentRequirementCreate {\n");
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

