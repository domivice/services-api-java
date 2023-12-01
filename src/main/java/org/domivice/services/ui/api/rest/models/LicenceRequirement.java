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

@Schema(name = "LicenceRequirement", description = "The service category licence requirements")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class LicenceRequirement {

    private UUID id;

    private State state;

    private Country country;

    @Valid
    private List<@Valid LicenceIssuer> licenceIssuers = new ArrayList<>();

    private LicenceType licenceType;

    private ServiceCategory serviceCategory;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endDate;

    private LicenceRequirementStatus status;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceRequirement#LicenceRequirement(UUID, State, Country, List<@Valid LicenceIssuer>, LicenceType, ServiceCategory, OffsetDateTime, LicenceRequirementStatus)}
     */
    @Deprecated
    public LicenceRequirement() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceRequirement(UUID id, State state, Country country, List<@Valid LicenceIssuer> licenceIssuers, LicenceType licenceType, ServiceCategory serviceCategory, OffsetDateTime startDate, LicenceRequirementStatus status) {
        this.id = id;
        this.state = state;
        this.country = country;
        this.licenceIssuers = licenceIssuers;
        this.licenceType = licenceType;
        this.serviceCategory = serviceCategory;
        this.startDate = startDate;
        this.status = status;
    }

    public LicenceRequirement id(UUID id) {
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

    public LicenceRequirement state(State state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     */
    @NotNull
    @Valid
    @Schema(name = "state", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LicenceRequirement country(Country country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
     */
    @NotNull
    @Valid
    @Schema(name = "country", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LicenceRequirement licenceIssuers(List<@Valid LicenceIssuer> licenceIssuers) {
        this.licenceIssuers = licenceIssuers;
        return this;
    }

    public LicenceRequirement addLicenceIssuersItem(LicenceIssuer licenceIssuersItem) {
        if (this.licenceIssuers == null) {
            this.licenceIssuers = new ArrayList<>();
        }
        this.licenceIssuers.add(licenceIssuersItem);
        return this;
    }

    /**
     * The accepted licence issuers
     *
     * @return licenceIssuers
     */
    @NotNull
    @Valid
    @Schema(name = "licenceIssuers", description = "The accepted licence issuers", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceIssuers")
    public List<@Valid LicenceIssuer> getLicenceIssuers() {
        return licenceIssuers;
    }

    public void setLicenceIssuers(List<@Valid LicenceIssuer> licenceIssuers) {
        this.licenceIssuers = licenceIssuers;
    }

    public LicenceRequirement licenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
        return this;
    }

    /**
     * Get licenceType
     *
     * @return licenceType
     */
    @NotNull
    @Valid
    @Schema(name = "licenceType", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("licenceType")
    public LicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public LicenceRequirement serviceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    /**
     * Get serviceCategory
     *
     * @return serviceCategory
     */
    @NotNull
    @Valid
    @Schema(name = "serviceCategory", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceCategory")
    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public LicenceRequirement startDate(OffsetDateTime startDate) {
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

    public LicenceRequirement endDate(OffsetDateTime endDate) {
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

    public LicenceRequirement status(LicenceRequirementStatus status) {
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
        LicenceRequirement licenceRequirement = (LicenceRequirement) o;
        return Objects.equals(this.id, licenceRequirement.id) &&
                Objects.equals(this.state, licenceRequirement.state) &&
                Objects.equals(this.country, licenceRequirement.country) &&
                Objects.equals(this.licenceIssuers, licenceRequirement.licenceIssuers) &&
                Objects.equals(this.licenceType, licenceRequirement.licenceType) &&
                Objects.equals(this.serviceCategory, licenceRequirement.serviceCategory) &&
                Objects.equals(this.startDate, licenceRequirement.startDate) &&
                Objects.equals(this.endDate, licenceRequirement.endDate) &&
                Objects.equals(this.status, licenceRequirement.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, country, licenceIssuers, licenceType, serviceCategory, startDate, endDate, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceRequirement {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    licenceIssuers: ").append(toIndentedString(licenceIssuers)).append("\n");
        sb.append("    licenceType: ").append(toIndentedString(licenceType)).append("\n");
        sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
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

