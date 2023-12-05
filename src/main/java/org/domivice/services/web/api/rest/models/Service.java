package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.Amenity;
import org.domivice.services.web.api.rest.models.BookingType;
import org.domivice.services.web.api.rest.models.BookingWindow;
import org.domivice.services.web.api.rest.models.BufferTime;
import org.domivice.services.web.api.rest.models.DaySchedule;
import org.domivice.services.web.api.rest.models.Licence;
import org.domivice.services.web.api.rest.models.LicenceRequirement;
import org.domivice.services.web.api.rest.models.Media;
import org.domivice.services.web.api.rest.models.ServiceCategory;
import org.domivice.services.web.api.rest.models.ServiceOffering;
import org.domivice.services.web.api.rest.models.ServiceProvider;
import org.domivice.services.web.api.rest.models.ServiceStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * 
 */

@Schema(name = "Service", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class Service {

  private UUID id;

  private Float rating;

  private BigDecimal reviewCount;

  private BufferTime bufferTime;

  private BookingWindow bookingWindow;

  private ServiceStatus status;

  private Float basePrice;

  private BigDecimal baseDuration;

  @Valid
  private Set<BookingType> bookingTypes = new LinkedHashSet<>();

  private String name;

  private String description;

  private ServiceProvider provider;

  @Valid
  private List<@Valid Licence> licences;

  @Valid
  private List<@Valid LicenceRequirement> licenceRequirements = new ArrayList<>();

  @Valid
  private List<@Valid ServiceOffering> serviceOfferings = new ArrayList<>();

  private ServiceCategory serviceCategory;

  @Valid
  private List<@Valid DaySchedule> weekSchedule = new ArrayList<>();

  @Valid
  private List<@Valid Media> gallery;

  private String slug;

  @Valid
  private List<@Valid Amenity> amenities;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime launchDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdated;

  /**
   * Default constructor
   * @deprecated Use {@link Service#Service(UUID, Float, BigDecimal, BufferTime, BookingWindow, ServiceStatus, Float, BigDecimal, Set<BookingType>, String, ServiceProvider, List<@Valid LicenceRequirement>, List<@Valid ServiceOffering>, ServiceCategory, List<@Valid DaySchedule>, String, OffsetDateTime, OffsetDateTime)}
   */
  @Deprecated
  public Service() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Service(UUID id, Float rating, BigDecimal reviewCount, BufferTime bufferTime, BookingWindow bookingWindow, ServiceStatus status, Float basePrice, BigDecimal baseDuration, Set<BookingType> bookingTypes, String name, ServiceProvider provider, List<@Valid LicenceRequirement> licenceRequirements, List<@Valid ServiceOffering> serviceOfferings, ServiceCategory serviceCategory, List<@Valid DaySchedule> weekSchedule, String slug, OffsetDateTime launchDate, OffsetDateTime lastUpdated) {
    this.id = id;
    this.rating = rating;
    this.reviewCount = reviewCount;
    this.bufferTime = bufferTime;
    this.bookingWindow = bookingWindow;
    this.status = status;
    this.basePrice = basePrice;
    this.baseDuration = baseDuration;
    this.bookingTypes = bookingTypes;
    this.name = name;
    this.provider = provider;
    this.licenceRequirements = licenceRequirements;
    this.serviceOfferings = serviceOfferings;
    this.serviceCategory = serviceCategory;
    this.weekSchedule = weekSchedule;
    this.slug = slug;
    this.launchDate = launchDate;
    this.lastUpdated = lastUpdated;
  }

  public Service id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The service id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The service id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Service rating(Float rating) {
    this.rating = rating;
    return this;
  }

  /**
   * The service rating
   * @return rating
  */
  @NotNull 
  @Schema(name = "rating", description = "The service rating", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rating")
  public Float getRating() {
    return rating;
  }

  public void setRating(Float rating) {
    this.rating = rating;
  }

  public Service reviewCount(BigDecimal reviewCount) {
    this.reviewCount = reviewCount;
    return this;
  }

  /**
   * The service review count
   * @return reviewCount
  */
  @NotNull @Valid 
  @Schema(name = "reviewCount", description = "The service review count", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("reviewCount")
  public BigDecimal getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(BigDecimal reviewCount) {
    this.reviewCount = reviewCount;
  }

  public Service bufferTime(BufferTime bufferTime) {
    this.bufferTime = bufferTime;
    return this;
  }

  /**
   * Get bufferTime
   * @return bufferTime
  */
  @NotNull @Valid 
  @Schema(name = "bufferTime", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bufferTime")
  public BufferTime getBufferTime() {
    return bufferTime;
  }

  public void setBufferTime(BufferTime bufferTime) {
    this.bufferTime = bufferTime;
  }

  public Service bookingWindow(BookingWindow bookingWindow) {
    this.bookingWindow = bookingWindow;
    return this;
  }

  /**
   * Get bookingWindow
   * @return bookingWindow
  */
  @NotNull @Valid 
  @Schema(name = "bookingWindow", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingWindow")
  public BookingWindow getBookingWindow() {
    return bookingWindow;
  }

  public void setBookingWindow(BookingWindow bookingWindow) {
    this.bookingWindow = bookingWindow;
  }

  public Service status(ServiceStatus status) {
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
  public ServiceStatus getStatus() {
    return status;
  }

  public void setStatus(ServiceStatus status) {
    this.status = status;
  }

  public Service basePrice(Float basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * The service base price
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

  public Service baseDuration(BigDecimal baseDuration) {
    this.baseDuration = baseDuration;
    return this;
  }

  /**
   * The service base duration in minutes
   * @return baseDuration
  */
  @NotNull @Valid 
  @Schema(name = "baseDuration", description = "The service base duration in minutes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("baseDuration")
  public BigDecimal getBaseDuration() {
    return baseDuration;
  }

  public void setBaseDuration(BigDecimal baseDuration) {
    this.baseDuration = baseDuration;
  }

  public Service bookingTypes(Set<BookingType> bookingTypes) {
    this.bookingTypes = bookingTypes;
    return this;
  }

  public Service addBookingTypesItem(BookingType bookingTypesItem) {
    if (this.bookingTypes == null) {
      this.bookingTypes = new LinkedHashSet<>();
    }
    this.bookingTypes.add(bookingTypesItem);
    return this;
  }

  /**
   * The supported booking types for this service
   * @return bookingTypes
  */
  @NotNull @Valid 
  @Schema(name = "bookingTypes", description = "The supported booking types for this service", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingTypes")
  public Set<BookingType> getBookingTypes() {
    return bookingTypes;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setBookingTypes(Set<BookingType> bookingTypes) {
    this.bookingTypes = bookingTypes;
  }

  public Service name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The service name
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

  public Service description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The service description
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

  public Service provider(ServiceProvider provider) {
    this.provider = provider;
    return this;
  }

  /**
   * Get provider
   * @return provider
  */
  @NotNull @Valid 
  @Schema(name = "provider", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("provider")
  public ServiceProvider getProvider() {
    return provider;
  }

  public void setProvider(ServiceProvider provider) {
    this.provider = provider;
  }

  public Service licences(List<@Valid Licence> licences) {
    this.licences = licences;
    return this;
  }

  public Service addLicencesItem(Licence licencesItem) {
    if (this.licences == null) {
      this.licences = new ArrayList<>();
    }
    this.licences.add(licencesItem);
    return this;
  }

  /**
   * The licences the service provider holds to be able to offer these services
   * @return licences
  */
  @Valid 
  @Schema(name = "licences", description = "The licences the service provider holds to be able to offer these services", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("licences")
  public List<@Valid Licence> getLicences() {
    return licences;
  }

  public void setLicences(List<@Valid Licence> licences) {
    this.licences = licences;
  }

  public Service licenceRequirements(List<@Valid LicenceRequirement> licenceRequirements) {
    this.licenceRequirements = licenceRequirements;
    return this;
  }

  public Service addLicenceRequirementsItem(LicenceRequirement licenceRequirementsItem) {
    if (this.licenceRequirements == null) {
      this.licenceRequirements = new ArrayList<>();
    }
    this.licenceRequirements.add(licenceRequirementsItem);
    return this;
  }

  /**
   * The licence requirements to be able to offer this service
   * @return licenceRequirements
  */
  @NotNull @Valid 
  @Schema(name = "licenceRequirements", description = "The licence requirements to be able to offer this service", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("licenceRequirements")
  public List<@Valid LicenceRequirement> getLicenceRequirements() {
    return licenceRequirements;
  }

  public void setLicenceRequirements(List<@Valid LicenceRequirement> licenceRequirements) {
    this.licenceRequirements = licenceRequirements;
  }

  public Service serviceOfferings(List<@Valid ServiceOffering> serviceOfferings) {
    this.serviceOfferings = serviceOfferings;
    return this;
  }

  public Service addServiceOfferingsItem(ServiceOffering serviceOfferingsItem) {
    if (this.serviceOfferings == null) {
      this.serviceOfferings = new ArrayList<>();
    }
    this.serviceOfferings.add(serviceOfferingsItem);
    return this;
  }

  /**
   * The service offerings
   * @return serviceOfferings
  */
  @NotNull @Valid 
  @Schema(name = "serviceOfferings", description = "The service offerings", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceOfferings")
  public List<@Valid ServiceOffering> getServiceOfferings() {
    return serviceOfferings;
  }

  public void setServiceOfferings(List<@Valid ServiceOffering> serviceOfferings) {
    this.serviceOfferings = serviceOfferings;
  }

  public Service serviceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
    return this;
  }

  /**
   * Get serviceCategory
   * @return serviceCategory
  */
  @NotNull @Valid 
  @Schema(name = "serviceCategory", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceCategory")
  public ServiceCategory getServiceCategory() {
    return serviceCategory;
  }

  public void setServiceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
  }

  public Service weekSchedule(List<@Valid DaySchedule> weekSchedule) {
    this.weekSchedule = weekSchedule;
    return this;
  }

  public Service addWeekScheduleItem(DaySchedule weekScheduleItem) {
    if (this.weekSchedule == null) {
      this.weekSchedule = new ArrayList<>();
    }
    this.weekSchedule.add(weekScheduleItem);
    return this;
  }

  /**
   * The service week schedule
   * @return weekSchedule
  */
  @NotNull @Valid 
  @Schema(name = "weekSchedule", description = "The service week schedule", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("weekSchedule")
  public List<@Valid DaySchedule> getWeekSchedule() {
    return weekSchedule;
  }

  public void setWeekSchedule(List<@Valid DaySchedule> weekSchedule) {
    this.weekSchedule = weekSchedule;
  }

  public Service gallery(List<@Valid Media> gallery) {
    this.gallery = gallery;
    return this;
  }

  public Service addGalleryItem(Media galleryItem) {
    if (this.gallery == null) {
      this.gallery = new ArrayList<>();
    }
    this.gallery.add(galleryItem);
    return this;
  }

  /**
   * The service image gallery
   * @return gallery
  */
  @Valid 
  @Schema(name = "gallery", description = "The service image gallery", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gallery")
  public List<@Valid Media> getGallery() {
    return gallery;
  }

  public void setGallery(List<@Valid Media> gallery) {
    this.gallery = gallery;
  }

  public Service slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * The service slug
   * @return slug
  */
  @NotNull 
  @Schema(name = "slug", description = "The service slug", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("slug")
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Service amenities(List<@Valid Amenity> amenities) {
    this.amenities = amenities;
    return this;
  }

  public Service addAmenitiesItem(Amenity amenitiesItem) {
    if (this.amenities == null) {
      this.amenities = new ArrayList<>();
    }
    this.amenities.add(amenitiesItem);
    return this;
  }

  /**
   * The service amenities
   * @return amenities
  */
  @Valid 
  @Schema(name = "amenities", description = "The service amenities", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amenities")
  public List<@Valid Amenity> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<@Valid Amenity> amenities) {
    this.amenities = amenities;
  }

  public Service launchDate(OffsetDateTime launchDate) {
    this.launchDate = launchDate;
    return this;
  }

  /**
   * The service launch date
   * @return launchDate
  */
  @NotNull @Valid 
  @Schema(name = "launchDate", description = "The service launch date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("launchDate")
  public OffsetDateTime getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(OffsetDateTime launchDate) {
    this.launchDate = launchDate;
  }

  public Service lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The date at which the service was last updated
   * @return lastUpdated
  */
  @NotNull @Valid 
  @Schema(name = "lastUpdated", description = "The date at which the service was last updated", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastUpdated")
  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Service service = (Service) o;
    return Objects.equals(this.id, service.id) &&
        Objects.equals(this.rating, service.rating) &&
        Objects.equals(this.reviewCount, service.reviewCount) &&
        Objects.equals(this.bufferTime, service.bufferTime) &&
        Objects.equals(this.bookingWindow, service.bookingWindow) &&
        Objects.equals(this.status, service.status) &&
        Objects.equals(this.basePrice, service.basePrice) &&
        Objects.equals(this.baseDuration, service.baseDuration) &&
        Objects.equals(this.bookingTypes, service.bookingTypes) &&
        Objects.equals(this.name, service.name) &&
        Objects.equals(this.description, service.description) &&
        Objects.equals(this.provider, service.provider) &&
        Objects.equals(this.licences, service.licences) &&
        Objects.equals(this.licenceRequirements, service.licenceRequirements) &&
        Objects.equals(this.serviceOfferings, service.serviceOfferings) &&
        Objects.equals(this.serviceCategory, service.serviceCategory) &&
        Objects.equals(this.weekSchedule, service.weekSchedule) &&
        Objects.equals(this.gallery, service.gallery) &&
        Objects.equals(this.slug, service.slug) &&
        Objects.equals(this.amenities, service.amenities) &&
        Objects.equals(this.launchDate, service.launchDate) &&
        Objects.equals(this.lastUpdated, service.lastUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rating, reviewCount, bufferTime, bookingWindow, status, basePrice, baseDuration, bookingTypes, name, description, provider, licences, licenceRequirements, serviceOfferings, serviceCategory, weekSchedule, gallery, slug, amenities, launchDate, lastUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Service {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    reviewCount: ").append(toIndentedString(reviewCount)).append("\n");
    sb.append("    bufferTime: ").append(toIndentedString(bufferTime)).append("\n");
    sb.append("    bookingWindow: ").append(toIndentedString(bookingWindow)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
    sb.append("    baseDuration: ").append(toIndentedString(baseDuration)).append("\n");
    sb.append("    bookingTypes: ").append(toIndentedString(bookingTypes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    licences: ").append(toIndentedString(licences)).append("\n");
    sb.append("    licenceRequirements: ").append(toIndentedString(licenceRequirements)).append("\n");
    sb.append("    serviceOfferings: ").append(toIndentedString(serviceOfferings)).append("\n");
    sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
    sb.append("    weekSchedule: ").append(toIndentedString(weekSchedule)).append("\n");
    sb.append("    gallery: ").append(toIndentedString(gallery)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
    sb.append("    launchDate: ").append(toIndentedString(launchDate)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
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

