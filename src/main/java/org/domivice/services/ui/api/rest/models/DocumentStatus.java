package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 * The document status
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public enum DocumentStatus {

    NEW("new"),

    ACCEPTED("accepted"),

    REJECTED("rejected");

    private String value;

    DocumentStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DocumentStatus fromValue(String value) {
        for (DocumentStatus b : DocumentStatus.values()) {
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

