package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The City Object
 */

@Schema(name = "City", description = "The City Object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class City {

  private String code;

  private String name;

  /**
   * Default constructor
   * @deprecated Use {@link City#City(String, String)}
   */
  @Deprecated
  public City() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public City(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public City code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The city code
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "The city code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public City name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The city name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The city name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return Objects.equals(this.code, city.code) &&
        Objects.equals(this.name, city.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

