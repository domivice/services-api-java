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

/**
 * The dates blocked by a service provider
 */

@Schema(name = "BlockedDateCreate", description = "The dates blocked by a service provider")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class BlockedDateCreate {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime endDate;

    @Valid
    private List<String> services = new ArrayList<>();

    private String serviceProviderId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link BlockedDateCreate#BlockedDateCreate(OffsetDateTime, OffsetDateTime, List<String>, String)}
     */
    @Deprecated
    public BlockedDateCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public BlockedDateCreate(OffsetDateTime startDate, OffsetDateTime endDate, List<String> services, String serviceProviderId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.services = services;
        this.serviceProviderId = serviceProviderId;
    }

    public BlockedDateCreate startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date
     *
     * @return startDate
     */
    @NotNull
    @Valid
    @Schema(name = "startDate", description = "The start date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("startDate")
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public BlockedDateCreate endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date
     *
     * @return endDate
     */
    @NotNull
    @Valid
    @Schema(name = "endDate", description = "The end date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("endDate")
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public BlockedDateCreate services(List<String> services) {
        this.services = services;
        return this;
    }

    public BlockedDateCreate addServicesItem(String servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * The ids for services for which the blocked dates apply
     *
     * @return services
     */
    @NotNull
    @Schema(name = "services", description = "The ids for services for which the blocked dates apply", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("services")
    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public BlockedDateCreate serviceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
        return this;
    }

    /**
     * The service provider id
     *
     * @return serviceProviderId
     */
    @NotNull
    @Schema(name = "serviceProviderId", description = "The service provider id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceProviderId")
    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlockedDateCreate blockedDateCreate = (BlockedDateCreate) o;
        return Objects.equals(this.startDate, blockedDateCreate.startDate) &&
                Objects.equals(this.endDate, blockedDateCreate.endDate) &&
                Objects.equals(this.services, blockedDateCreate.services) &&
                Objects.equals(this.serviceProviderId, blockedDateCreate.serviceProviderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, services, serviceProviderId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BlockedDateCreate {\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
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

