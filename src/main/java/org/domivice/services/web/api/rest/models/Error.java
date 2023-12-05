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
 * 
 */

@Schema(name = "Error", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class Error {

  private String detail;

  private String instance;

  private String status;

  private String title;

  private String type;

  /**
   * Default constructor
   * @deprecated Use {@link Error#Error(String, String, String, String)}
   */
  @Deprecated
  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(String detail, String instance, String title, String type) {
    this.detail = detail;
    this.instance = instance;
    this.title = title;
    this.type = type;
  }

  public Error detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human-readable explanation of the error
   * @return detail
  */
  @NotNull 
  @Schema(name = "detail", description = "A human-readable explanation of the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Error instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * A URI that identifies the specific occurrence of the error
   * @return instance
  */
  @NotNull 
  @Schema(name = "instance", description = "A URI that identifies the specific occurrence of the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("instance")
  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  public Error status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP response code
   * @return status
  */
  
  @Schema(name = "status", description = "The HTTP response code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Error title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A brief, human-readable message about the error
   * @return title
  */
  @NotNull 
  @Schema(name = "title", description = "A brief, human-readable message about the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A URI identifier that categorizes the error
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "A URI identifier that categorizes the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.detail, error.detail) &&
        Objects.equals(this.instance, error.instance) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.title, error.title) &&
        Objects.equals(this.type, error.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detail, instance, status, title, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

