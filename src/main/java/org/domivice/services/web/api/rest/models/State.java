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
 * The state object
 */

@Schema(name = "State", description = "The state object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class State {

  private String code;

  private String name;

  /**
   * Default constructor
   * @deprecated Use {@link State#State(String, String)}
   */
  @Deprecated
  public State() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public State(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public State code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The state code
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "The state code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public State name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The state name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The state name", requiredMode = Schema.RequiredMode.REQUIRED)
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
    State state = (State) o;
    return Objects.equals(this.code, state.code) &&
        Objects.equals(this.name, state.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class State {\n");
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

