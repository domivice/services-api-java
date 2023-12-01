package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 *
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public enum LicenceStatus {

    DRAFT("draft"),

    NEW("new"),

    ACCEPTED("accepted"),

    REJECTED("rejected"),

    EXPIRED("expired"),

    REVOKED("revoked");

    private String value;

    LicenceStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static LicenceStatus fromValue(String value) {
        for (LicenceStatus b : LicenceStatus.values()) {
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

