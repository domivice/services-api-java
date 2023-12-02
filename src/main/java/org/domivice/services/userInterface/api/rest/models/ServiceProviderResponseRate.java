package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;

/**
 * The service provider response rate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public enum ServiceProviderResponseRate {

    UNKNOWN("unknown"),

    ANHOUR("anHour"),

    AFEWHOURS("aFewHours"),

    ADAY("aDay"),

    AFEWDAYS("aFewDays");

    private String value;

    ServiceProviderResponseRate(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceProviderResponseRate fromValue(String value) {
        for (ServiceProviderResponseRate b : ServiceProviderResponseRate.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

