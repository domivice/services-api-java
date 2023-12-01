package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * The service offering object. Service offerings of type base should have no price (set to 0) and duration (set to 0). Service offerings of type add-on should have a price (greater than 0) and duration (greater than 0)
 */

@Schema(name = "ServiceOfferingPatch", description = "The service offering object. Service offerings of type base should have no price (set to 0) and duration (set to 0). Service offerings of type add-on should have a price (greater than 0) and duration (greater than 0)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceOfferingPatch {

    private UUID id;

    private UUID serviceId;

    private ServiceOfferingType type;

    private BigDecimal duration;

    private Float price;

    private String name;

    private String description;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceOfferingPatch#ServiceOfferingPatch(UUID, UUID, ServiceOfferingType, BigDecimal, Float, String)}
     */
    @Deprecated
    public ServiceOfferingPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceOfferingPatch(UUID id, UUID serviceId, ServiceOfferingType type, BigDecimal duration, Float price, String name) {
        this.id = id;
        this.serviceId = serviceId;
        this.type = type;
        this.duration = duration;
        this.price = price;
        this.name = name;
    }

    public ServiceOfferingPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The service offering id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The service offering id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ServiceOfferingPatch serviceId(UUID serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * The service offering parent service id
     *
     * @return serviceId
     */
    @NotNull
    @Valid
    @Schema(name = "serviceId", description = "The service offering parent service id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceId")
    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceOfferingPatch type(ServiceOfferingType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @NotNull
    @Valid
    @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("type")
    public ServiceOfferingType getType() {
        return type;
    }

    public void setType(ServiceOfferingType type) {
        this.type = type;
    }

    public ServiceOfferingPatch duration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    /**
     * The service offering duration in minutes
     *
     * @return duration
     */
    @NotNull
    @Valid
    @Schema(name = "duration", description = "The service offering duration in minutes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("duration")
    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public ServiceOfferingPatch price(Float price) {
        this.price = price;
        return this;
    }

    /**
     * The service offering price
     *
     * @return price
     */
    @NotNull
    @Schema(name = "price", description = "The service offering price ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ServiceOfferingPatch name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The service offering name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The service offering name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceOfferingPatch description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The service offering description
     *
     * @return description
     */

    @Schema(name = "description", description = "The service offering description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceOfferingPatch serviceOfferingPatch = (ServiceOfferingPatch) o;
        return Objects.equals(this.id, serviceOfferingPatch.id) &&
                Objects.equals(this.serviceId, serviceOfferingPatch.serviceId) &&
                Objects.equals(this.type, serviceOfferingPatch.type) &&
                Objects.equals(this.duration, serviceOfferingPatch.duration) &&
                Objects.equals(this.price, serviceOfferingPatch.price) &&
                Objects.equals(this.name, serviceOfferingPatch.name) &&
                Objects.equals(this.description, serviceOfferingPatch.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceId, type, duration, price, name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceOfferingPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

