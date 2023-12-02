package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;

import java.util.Objects;

/**
 * The country object
 */

@Schema(name = "Country", description = "The country object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class Country {

    private String code;

    private String name;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Country#Country(String, String)}
     */
    @Deprecated
    public Country() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The country code
     *
     * @return code
     */
    @NotNull
    @Schema(name = "code", description = "The country code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The country name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The country name", requiredMode = Schema.RequiredMode.REQUIRED)
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
        Country country = (Country) o;
        return Objects.equals(this.code, country.code) &&
                Objects.equals(this.name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Country {\n");
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

