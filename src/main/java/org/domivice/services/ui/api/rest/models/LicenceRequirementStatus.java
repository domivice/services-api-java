package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 *
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public enum LicenceRequirementStatus {

    ENABLED("enabled"),

    DISABLED("disabled");

    private String value;

    LicenceRequirementStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static LicenceRequirementStatus fromValue(String value) {
        for (LicenceRequirementStatus b : LicenceRequirementStatus.values()) {
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

