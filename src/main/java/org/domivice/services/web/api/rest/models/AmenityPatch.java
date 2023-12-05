package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A text block
 */

@Schema(name = "AmenityPatch", description = "A text block")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class AmenityPatch {

  private String name;

  private String icon;

  private String description;

  private UUID id;

  /**
   * Default constructor
   * @deprecated Use {@link AmenityPatch#AmenityPatch(UUID)}
   */
  @Deprecated
  public AmenityPatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AmenityPatch(UUID id) {
    this.id = id;
  }

  public AmenityPatch name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The amenity title
   * @return name
  */
  
  @Schema(name = "name", description = "The amenity title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AmenityPatch icon(String icon) {
    this.icon = icon;
    return this;
  }

  /**
   * The amenity icon
   * @return icon
  */
  
  @Schema(name = "icon", description = "The amenity icon", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("icon")
  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public AmenityPatch description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The amenity description
   * @return description
  */
  
  @Schema(name = "description", description = "The amenity description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AmenityPatch id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The amenity id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "The amenity id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmenityPatch amenityPatch = (AmenityPatch) o;
    return Objects.equals(this.name, amenityPatch.name) &&
        Objects.equals(this.icon, amenityPatch.icon) &&
        Objects.equals(this.description, amenityPatch.description) &&
        Objects.equals(this.id, amenityPatch.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, icon, description, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmenityPatch {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

