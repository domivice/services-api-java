package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The service status enumeration type
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public enum ServiceStatus {
  
  ONLINE("online"),
  
  OFFLINE("offline"),
  
  DRAFT("draft"),
  
  MODERATION("moderation"),
  
  READY("ready"),
  
  ARCHIVED("archived");

  private String value;

  ServiceStatus(String value) {
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
  public static ServiceStatus fromValue(String value) {
    for (ServiceStatus b : ServiceStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

