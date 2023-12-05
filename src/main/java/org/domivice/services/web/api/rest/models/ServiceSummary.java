package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.domivice.services.web.api.rest.models.BookingType;
import org.domivice.services.web.api.rest.models.ServiceCategory;
import org.domivice.services.web.api.rest.models.ServiceProvider;
import org.domivice.services.web.api.rest.models.ServiceStatus;
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

@Schema(name = "ServiceSummary", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class ServiceSummary {

  private UUID id;

  private Float rating;

  private BigDecimal reviewCount;

  private ServiceStatus status;

  private Float basePrice;

  private BigDecimal baseDuration;

  @Valid
  private Set<BookingType> bookingTypes = new LinkedHashSet<>();

  private String name;

  private String description;

  private ServiceProvider provider;

  private ServiceCategory serviceCategory;

  private String slug;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceSummary#ServiceSummary(UUID, Float, BigDecimal, ServiceStatus, Float, BigDecimal, Set<BookingType>, String, ServiceProvider, ServiceCategory, String)}
   */
  @Deprecated
  public ServiceSummary() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceSummary(UUID id, Float rating, BigDecimal reviewCount, ServiceStatus status, Float basePrice, BigDecimal baseDuration, Set<BookingType> bookingTypes, String name, ServiceProvider provider, ServiceCategory serviceCategory, String slug) {
    this.id = id;
    this.rating = rating;
    this.reviewCount = reviewCount;
    this.status = status;
    this.basePrice = basePrice;
    this.baseDuration = baseDuration;
    this.bookingTypes = bookingTypes;
    this.name = name;
    this.provider = provider;
    this.serviceCategory = serviceCategory;
    this.slug = slug;
  }

  public ServiceSummary id(UUID id) {
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

  public ServiceSummary rating(Float rating) {
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

  public ServiceSummary reviewCount(BigDecimal reviewCount) {
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

  public ServiceSummary status(ServiceStatus status) {
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

  public ServiceSummary basePrice(Float basePrice) {
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

  public ServiceSummary baseDuration(BigDecimal baseDuration) {
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

  public ServiceSummary bookingTypes(Set<BookingType> bookingTypes) {
    this.bookingTypes = bookingTypes;
    return this;
  }

  public ServiceSummary addBookingTypesItem(BookingType bookingTypesItem) {
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

  public ServiceSummary name(String name) {
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

  public ServiceSummary description(String description) {
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

  public ServiceSummary provider(ServiceProvider provider) {
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

  public ServiceSummary serviceCategory(ServiceCategory serviceCategory) {
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

  public ServiceSummary slug(String slug) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSummary serviceSummary = (ServiceSummary) o;
    return Objects.equals(this.id, serviceSummary.id) &&
        Objects.equals(this.rating, serviceSummary.rating) &&
        Objects.equals(this.reviewCount, serviceSummary.reviewCount) &&
        Objects.equals(this.status, serviceSummary.status) &&
        Objects.equals(this.basePrice, serviceSummary.basePrice) &&
        Objects.equals(this.baseDuration, serviceSummary.baseDuration) &&
        Objects.equals(this.bookingTypes, serviceSummary.bookingTypes) &&
        Objects.equals(this.name, serviceSummary.name) &&
        Objects.equals(this.description, serviceSummary.description) &&
        Objects.equals(this.provider, serviceSummary.provider) &&
        Objects.equals(this.serviceCategory, serviceSummary.serviceCategory) &&
        Objects.equals(this.slug, serviceSummary.slug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rating, reviewCount, status, basePrice, baseDuration, bookingTypes, name, description, provider, serviceCategory, slug);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSummary {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    reviewCount: ").append(toIndentedString(reviewCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
    sb.append("    baseDuration: ").append(toIndentedString(baseDuration)).append("\n");
    sb.append("    bookingTypes: ").append(toIndentedString(bookingTypes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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

