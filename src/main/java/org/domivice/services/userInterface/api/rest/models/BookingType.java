package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;

/**
 *
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public enum BookingType {

    ONETIME("oneTime"),

    RECURRENT("recurrent");

    private String value;

    BookingType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BookingType fromValue(String value) {
        for (BookingType b : BookingType.values()) {
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

