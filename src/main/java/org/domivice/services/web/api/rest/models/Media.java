package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The file data type
 */

@Schema(name = "Media", description = "The file data type")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class Media {

  private String id;

  private String url;

  /**
   * The media mime type
   */
  public enum MimeTypeEnum {
    IMAGE_JPEG("image/jpeg"),
    
    IMAGE_PNG("image/png"),
    
    APPLICATION_PDF("application/pdf");

    private String value;

    MimeTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MimeTypeEnum fromValue(String value) {
      for (MimeTypeEnum b : MimeTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private MimeTypeEnum mimeType;

  /**
   * Default constructor
   * @deprecated Use {@link Media#Media(String, String, MimeTypeEnum)}
   */
  @Deprecated
  public Media() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Media(String id, String url, MimeTypeEnum mimeType) {
    this.id = id;
    this.url = url;
    this.mimeType = mimeType;
  }

  public Media id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The file id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "The file id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Media url(String url) {
    this.url = url;
    return this;
  }

  /**
   * The media url
   * @return url
  */
  @NotNull 
  @Schema(name = "url", description = "The media url", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Media mimeType(MimeTypeEnum mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * The media mime type
   * @return mimeType
  */
  @NotNull 
  @Schema(name = "mimeType", description = "The media mime type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mimeType")
  public MimeTypeEnum getMimeType() {
    return mimeType;
  }

  public void setMimeType(MimeTypeEnum mimeType) {
    this.mimeType = mimeType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Media media = (Media) o;
    return Objects.equals(this.id, media.id) &&
        Objects.equals(this.url, media.url) &&
        Objects.equals(this.mimeType, media.mimeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, mimeType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Media {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
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

