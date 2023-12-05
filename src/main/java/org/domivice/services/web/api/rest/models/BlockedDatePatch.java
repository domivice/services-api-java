package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The dates blocked by a service provider
 */

@Schema(name = "BlockedDatePatch", description = "The dates blocked by a service provider")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class BlockedDatePatch {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  @Valid
  private List<String> services;

  private UUID id;

  private UUID serviceProviderId;

  /**
   * Default constructor
   * @deprecated Use {@link BlockedDatePatch#BlockedDatePatch(UUID, UUID)}
   */
  @Deprecated
  public BlockedDatePatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BlockedDatePatch(UUID id, UUID serviceProviderId) {
    this.id = id;
    this.serviceProviderId = serviceProviderId;
  }

  public BlockedDatePatch startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The start date
   * @return startDate
  */
  @Valid 
  @Schema(name = "startDate", description = "The start date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public BlockedDatePatch endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The end date
   * @return endDate
  */
  @Valid 
  @Schema(name = "endDate", description = "The end date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public BlockedDatePatch services(List<String> services) {
    this.services = services;
    return this;
  }

  public BlockedDatePatch addServicesItem(String servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * The ids for services for which the blocked dates apply
   * @return services
  */
  
  @Schema(name = "services", description = "The ids for services for which the blocked dates apply", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("services")
  public List<String> getServices() {
    return services;
  }

  public void setServices(List<String> services) {
    this.services = services;
  }

  public BlockedDatePatch id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The blocked date id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The blocked date id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public BlockedDatePatch serviceProviderId(UUID serviceProviderId) {
    this.serviceProviderId = serviceProviderId;
    return this;
  }

  /**
   * The service provider id
   * @return serviceProviderId
  */
  @NotNull @Valid 
  @Schema(name = "serviceProviderId", description = "The service provider id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serviceProviderId")
  public UUID getServiceProviderId() {
    return serviceProviderId;
  }

  public void setServiceProviderId(UUID serviceProviderId) {
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
    BlockedDatePatch blockedDatePatch = (BlockedDatePatch) o;
    return Objects.equals(this.startDate, blockedDatePatch.startDate) &&
        Objects.equals(this.endDate, blockedDatePatch.endDate) &&
        Objects.equals(this.services, blockedDatePatch.services) &&
        Objects.equals(this.id, blockedDatePatch.id) &&
        Objects.equals(this.serviceProviderId, blockedDatePatch.serviceProviderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate, services, id, serviceProviderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockedDatePatch {\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

