package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 */

@Schema(name = "ServiceCreate", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceCreate {

    @Valid
    private List<@Valid DaySchedule> schedule = new ArrayList<>();

    private BufferTime bufferTime;

    private BookingWindow bookingWindow;

    private Float basePrice;

    private BigDecimal baseDuration;

    @Valid
    private Set<BookingType> bookingTypes = new LinkedHashSet<>();

    private String name;

    private String description;

    private String serviceCategoryId;

    private String serviceProviderId;

    @Valid
    private List<String> amenities;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceCreate#ServiceCreate(List<@Valid DaySchedule>, BufferTime, BookingWindow, Float, BigDecimal, Set<BookingType>, String, String, String)}
     */
    @Deprecated
    public ServiceCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceCreate(List<@Valid DaySchedule> schedule, BufferTime bufferTime, BookingWindow bookingWindow, Float basePrice, BigDecimal baseDuration, Set<BookingType> bookingTypes, String name, String serviceCategoryId, String serviceProviderId) {
        this.schedule = schedule;
        this.bufferTime = bufferTime;
        this.bookingWindow = bookingWindow;
        this.basePrice = basePrice;
        this.baseDuration = baseDuration;
        this.bookingTypes = bookingTypes;
        this.name = name;
        this.serviceCategoryId = serviceCategoryId;
        this.serviceProviderId = serviceProviderId;
    }

    public ServiceCreate schedule(List<@Valid DaySchedule> schedule) {
        this.schedule = schedule;
        return this;
    }

    public ServiceCreate addScheduleItem(DaySchedule scheduleItem) {
        if (this.schedule == null) {
            this.schedule = new ArrayList<>();
        }
        this.schedule.add(scheduleItem);
        return this;
    }

    /**
     * The service weekly schedule
     *
     * @return schedule
     */
    @NotNull
    @Valid
    @Schema(name = "schedule", description = "The service weekly schedule", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("schedule")
    public List<@Valid DaySchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<@Valid DaySchedule> schedule) {
        this.schedule = schedule;
    }

    public ServiceCreate bufferTime(BufferTime bufferTime) {
        this.bufferTime = bufferTime;
        return this;
    }

    /**
     * Get bufferTime
     *
     * @return bufferTime
     */
    @NotNull
    @Valid
    @Schema(name = "bufferTime", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("bufferTime")
    public BufferTime getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(BufferTime bufferTime) {
        this.bufferTime = bufferTime;
    }

    public ServiceCreate bookingWindow(BookingWindow bookingWindow) {
        this.bookingWindow = bookingWindow;
        return this;
    }

    /**
     * Get bookingWindow
     *
     * @return bookingWindow
     */
    @NotNull
    @Valid
    @Schema(name = "bookingWindow", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("bookingWindow")
    public BookingWindow getBookingWindow() {
        return bookingWindow;
    }

    public void setBookingWindow(BookingWindow bookingWindow) {
        this.bookingWindow = bookingWindow;
    }

    public ServiceCreate basePrice(Float basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    /**
     * The service base price
     *
     * @return basePrice
     */
    @NotNull
    @Schema(name = "basePrice", description = "The service base price", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("basePrice")
    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public ServiceCreate baseDuration(BigDecimal baseDuration) {
        this.baseDuration = baseDuration;
        return this;
    }

    /**
     * The service base duration in minutes
     *
     * @return baseDuration
     */
    @NotNull
    @Valid
    @Schema(name = "baseDuration", description = "The service base duration in minutes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("baseDuration")
    public BigDecimal getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(BigDecimal baseDuration) {
        this.baseDuration = baseDuration;
    }

    public ServiceCreate bookingTypes(Set<BookingType> bookingTypes) {
        this.bookingTypes = bookingTypes;
        return this;
    }

    public ServiceCreate addBookingTypesItem(BookingType bookingTypesItem) {
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
    @NotNull
    @Valid
    @Schema(name = "bookingTypes", description = "The supported booking types for this service", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("bookingTypes")
    public Set<BookingType> getBookingTypes() {
        return bookingTypes;
    }

    @JsonDeserialize(as = LinkedHashSet.class)
    public void setBookingTypes(Set<BookingType> bookingTypes) {
        this.bookingTypes = bookingTypes;
    }

    public ServiceCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The service name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The service name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceCreate description(String description) {
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

    public ServiceCreate serviceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
        return this;
    }

    /**
     * The service category id
     *
     * @return serviceCategoryId
     */
    @NotNull
    @Schema(name = "serviceCategoryId", description = "The service category id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceCategoryId")
    public String getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public ServiceCreate serviceProviderId(String serviceProviderId) {
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

    public ServiceCreate amenities(List<String> amenities) {
        this.amenities = amenities;
        return this;
    }

    public ServiceCreate addAmenitiesItem(String amenitiesItem) {
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

    @Schema(name = "amenities", description = "The amenity ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("amenities")
    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
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
        ServiceCreate serviceCreate = (ServiceCreate) o;
        return Objects.equals(this.schedule, serviceCreate.schedule) &&
                Objects.equals(this.bufferTime, serviceCreate.bufferTime) &&
                Objects.equals(this.bookingWindow, serviceCreate.bookingWindow) &&
                Objects.equals(this.basePrice, serviceCreate.basePrice) &&
                Objects.equals(this.baseDuration, serviceCreate.baseDuration) &&
                Objects.equals(this.bookingTypes, serviceCreate.bookingTypes) &&
                Objects.equals(this.name, serviceCreate.name) &&
                Objects.equals(this.description, serviceCreate.description) &&
                Objects.equals(this.serviceCategoryId, serviceCreate.serviceCategoryId) &&
                Objects.equals(this.serviceProviderId, serviceCreate.serviceProviderId) &&
                Objects.equals(this.amenities, serviceCreate.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, bufferTime, bookingWindow, basePrice, baseDuration, bookingTypes, name, description, serviceCategoryId, serviceProviderId, amenities);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceCreate {\n");
        sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
        sb.append("    bufferTime: ").append(toIndentedString(bufferTime)).append("\n");
        sb.append("    bookingWindow: ").append(toIndentedString(bookingWindow)).append("\n");
        sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
        sb.append("    baseDuration: ").append(toIndentedString(baseDuration)).append("\n");
        sb.append("    bookingTypes: ").append(toIndentedString(bookingTypes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
        sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
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

