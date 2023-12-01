package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 * The service provider response rate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
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

