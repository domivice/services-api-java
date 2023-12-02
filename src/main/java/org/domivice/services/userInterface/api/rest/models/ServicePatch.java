package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 */

@Schema(name = "ServicePatch", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class ServicePatch {

    private UUID id;

    private BufferTime bufferTime;

    private BookingWindow bookingWindow;

    private Float basePrice;

    private BigDecimal baseDuration;

    @Valid
    private Set<BookingType> bookingTypes;

    private String name;

    private String description;

    private UUID serviceCategoryId;

    private UUID serviceProviderId;

    @Valid
    private List<@Valid DaySchedule> weekSchedule;

    @Valid
    private List<UUID> amenities;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServicePatch#ServicePatch(UUID)}
     */
    @Deprecated
    public ServicePatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServicePatch(UUID id) {
        this.id = id;
    }

    public ServicePatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The service id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The service id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ServicePatch bufferTime(BufferTime bufferTime) {
        this.bufferTime = bufferTime;
        return this;
    }

    /**
     * Get bufferTime
     *
     * @return bufferTime
     */
    @Valid
    @Schema(name = "bufferTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("bufferTime")
    public BufferTime getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(BufferTime bufferTime) {
        this.bufferTime = bufferTime;
    }

    public ServicePatch bookingWindow(BookingWindow bookingWindow) {
        this.bookingWindow = bookingWindow;
        return this;
    }

    /**
     * Get bookingWindow
     *
     * @return bookingWindow
     */
    @Valid
    @Schema(name = "bookingWindow", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("bookingWindow")
    public BookingWindow getBookingWindow() {
        return bookingWindow;
    }

    public void setBookingWindow(BookingWindow bookingWindow) {
        this.bookingWindow = bookingWindow;
    }

    public ServicePatch basePrice(Float basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    /**
     * The service base price
     *
     * @return basePrice
     */

    @Schema(name = "basePrice", description = "The service base price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("basePrice")
    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public ServicePatch baseDuration(BigDecimal baseDuration) {
        this.baseDuration = baseDuration;
        return this;
    }

    /**
     * The service base duration in minutes
     *
     * @return baseDuration
     */
    @Valid
    @Schema(name = "baseDuration", description = "The service base duration in minutes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("baseDuration")
    public BigDecimal getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(BigDecimal baseDuration) {
        this.baseDuration = baseDuration;
    }

    public ServicePatch bookingTypes(Set<BookingType> bookingTypes) {
        this.bookingTypes = bookingTypes;
        return this;
    }

    public ServicePatch addBookingTypesItem(BookingType bookingTypesItem) {
        if (this.bookingTypes == null) {
            this.bookingTypes = new LinkedHashSet<>();
        }
        this.bookingTypes.add(bookingTypesItem);
        return this;
    }

    /**
     * The supported booking types for this service
     *
     * @return bookingTypes
     */
    @Valid
    @Schema(name = "bookingTypes", description = "The supported booking types for this service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("bookingTypes")
    public Set<BookingType> getBookingTypes() {
        return bookingTypes;
    }

    @JsonDeserialize(as = LinkedHashSet.class)
    public void setBookingTypes(Set<BookingType> bookingTypes) {
        this.bookingTypes = bookingTypes;
    }

    public ServicePatch name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The service name
     *
     * @return name
     */

    @Schema(name = "name", description = "The service name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServicePatch description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The service description
     *
     * @return description
     */

    @Schema(name = "description", description = "The service description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServicePatch serviceCategoryId(UUID serviceCategoryId) {
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

    public ServicePatch serviceProviderId(UUID serviceProviderId) {
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

    public ServicePatch weekSchedule(List<@Valid DaySchedule> weekSchedule) {
        this.weekSchedule = weekSchedule;
        return this;
    }

    public ServicePatch addWeekScheduleItem(DaySchedule weekScheduleItem) {
        if (this.weekSchedule == null) {
            this.weekSchedule = new ArrayList<>();
        }
        this.weekSchedule.add(weekScheduleItem);
        return this;
    }

    /**
     * The service weekly schedule
     *
     * @return weekSchedule
     */
    @Valid
    @Schema(name = "weekSchedule", description = "The service weekly schedule", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("weekSchedule")
    public List<@Valid DaySchedule> getWeekSchedule() {
        return weekSchedule;
    }

    public void setWeekSchedule(List<@Valid DaySchedule> weekSchedule) {
        this.weekSchedule = weekSchedule;
    }

    public ServicePatch amenities(List<UUID> amenities) {
        this.amenities = amenities;
        return this;
    }

    public ServicePatch addAmenitiesItem(UUID amenitiesItem) {
        if (this.amenities == null) {
            this.amenities = new ArrayList<>();
        }
        this.amenities.add(amenitiesItem);
        return this;
    }

    /**
     * The amenity ids
     *
     * @return amenities
     */
    @Valid
    @Schema(name = "amenities", description = "The amenity ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("amenities")
    public List<UUID> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<UUID> amenities) {
        this.amenities = amenities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServicePatch servicePatch = (ServicePatch) o;
        return Objects.equals(this.id, servicePatch.id) &&
                Objects.equals(this.bufferTime, servicePatch.bufferTime) &&
                Objects.equals(this.bookingWindow, servicePatch.bookingWindow) &&
                Objects.equals(this.basePrice, servicePatch.basePrice) &&
                Objects.equals(this.baseDuration, servicePatch.baseDuration) &&
                Objects.equals(this.bookingTypes, servicePatch.bookingTypes) &&
                Objects.equals(this.name, servicePatch.name) &&
                Objects.equals(this.description, servicePatch.description) &&
                Objects.equals(this.serviceCategoryId, servicePatch.serviceCategoryId) &&
                Objects.equals(this.serviceProviderId, servicePatch.serviceProviderId) &&
                Objects.equals(this.weekSchedule, servicePatch.weekSchedule) &&
                Objects.equals(this.amenities, servicePatch.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bufferTime, bookingWindow, basePrice, baseDuration, bookingTypes, name, description, serviceCategoryId, serviceProviderId, weekSchedule, amenities);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServicePatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    bufferTime: ").append(toIndentedString(bufferTime)).append("\n");
        sb.append("    bookingWindow: ").append(toIndentedString(bookingWindow)).append("\n");
        sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
        sb.append("    baseDuration: ").append(toIndentedString(baseDuration)).append("\n");
        sb.append("    bookingTypes: ").append(toIndentedString(bookingTypes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
        sb.append("    weekSchedule: ").append(toIndentedString(weekSchedule)).append("\n");
        sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
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

