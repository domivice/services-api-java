package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The licence type object
 */

@Schema(name = "LicenceTypeCreate", description = "The licence type object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class LicenceTypeCreate {

    private String name;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceTypeCreate#LicenceTypeCreate(String)}
     */
    @Deprecated
    public LicenceTypeCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceTypeCreate(String name) {
        this.name = name;
    }

    public LicenceTypeCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The licence type name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The licence type name", requiredMode = Schema.RequiredMode.REQUIRED)
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
        LicenceTypeCreate licenceTypeCreate = (LicenceTypeCreate) o;
        return Objects.equals(this.name, licenceTypeCreate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceTypeCreate {\n");
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

