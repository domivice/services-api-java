package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The service category licence requirements
 */

@Schema(name = "LicenceRequirementPatch", description = "The service category licence requirements")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class LicenceRequirementPatch {

    private UUID id;

    private UUID serviceCategoryId;

    private String countryCode;

    @Valid
    private List<UUID> licenceIssuerIds;

    private UUID licenceTypeId;

    private String stateCode;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endDate;

    private LicenceRequirementStatus status;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceRequirementPatch#LicenceRequirementPatch(UUID)}
     */
    @Deprecated
    public LicenceRequirementPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceRequirementPatch(UUID id) {
        this.id = id;
    }

    public LicenceRequirementPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The licence requirement id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The licence requirement id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LicenceRequirementPatch serviceCategoryId(UUID serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
        return this;
    }

    /**
     * The service category id
     *
     * @return serviceCategoryId
     */
    @Valid
    @Schema(name = "serviceCategoryId", description = "The service category id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("serviceCategoryId")
    public UUID getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(UUID serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public LicenceRequirementPatch countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The requiring country code
     *
     * @return countryCode
     */

    @Schema(name = "countryCode", description = "The requiring country code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public LicenceRequirementPatch licenceIssuerIds(List<UUID> licenceIssuerIds) {
        this.licenceIssuerIds = licenceIssuerIds;
        return this;
    }

    public LicenceRequirementPatch addLicenceIssuerIdsItem(UUID licenceIssuerIdsItem) {
        if (this.licenceIssuerIds == null) {
            this.licenceIssuerIds = new ArrayList<>();
        }
        this.licenceIssuerIds.add(licenceIssuerIdsItem);
        return this;
    }

    /**
     * The accepted licence issuer ids
     *
     * @return licenceIssuerIds
     */
    @Valid
    @Schema(name = "licenceIssuerIds", description = "The accepted licence issuer ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("licenceIssuerIds")
    public List<UUID> getLicenceIssuerIds() {
        return licenceIssuerIds;
    }

    public void setLicenceIssuerIds(List<UUID> licenceIssuerIds) {
        this.licenceIssuerIds = licenceIssuerIds;
    }

    public LicenceRequirementPatch licenceTypeId(UUID licenceTypeId) {
        this.licenceTypeId = licenceTypeId;
        return this;
    }

    /**
     * The licence type id
     *
     * @return licenceTypeId
     */
    @Valid
    @Schema(name = "licenceTypeId", description = "The licence type id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("licenceTypeId")
    public UUID getLicenceTypeId() {
        return licenceTypeId;
    }

    public void setLicenceTypeId(UUID licenceTypeId) {
        this.licenceTypeId = licenceTypeId;
    }

    public LicenceRequirementPatch stateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    /**
     * The requiring state
     *
     * @return stateCode
     */

    @Schema(name = "stateCode", description = "The requiring state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("stateCode")
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public LicenceRequirementPatch startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The requirement start date
     *
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

    public LicenceRequirementPatch endDate(OffsetDateTime endDate) {
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

    public LicenceRequirementPatch status(LicenceRequirementStatus status) {
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
    public LicenceRequirementStatus getStatus() {
        return status;
    }

    public void setStatus(LicenceRequirementStatus status) {
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
        LicenceRequirementPatch licenceRequirementPatch = (LicenceRequirementPatch) o;
        return Objects.equals(this.id, licenceRequirementPatch.id) &&
                Objects.equals(this.serviceCategoryId, licenceRequirementPatch.serviceCategoryId) &&
                Objects.equals(this.countryCode, licenceRequirementPatch.countryCode) &&
                Objects.equals(this.licenceIssuerIds, licenceRequirementPatch.licenceIssuerIds) &&
                Objects.equals(this.licenceTypeId, licenceRequirementPatch.licenceTypeId) &&
                Objects.equals(this.stateCode, licenceRequirementPatch.stateCode) &&
                Objects.equals(this.startDate, licenceRequirementPatch.startDate) &&
                Objects.equals(this.endDate, licenceRequirementPatch.endDate) &&
                Objects.equals(this.status, licenceRequirementPatch.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceCategoryId, countryCode, licenceIssuerIds, licenceTypeId, stateCode, startDate, endDate, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceRequirementPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    licenceIssuerIds: ").append(toIndentedString(licenceIssuerIds)).append("\n");
        sb.append("    licenceTypeId: ").append(toIndentedString(licenceTypeId)).append("\n");
        sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

