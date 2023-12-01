package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * The licence type object
 */

@Schema(name = "LicenceTypePatch", description = "The licence type object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class LicenceTypePatch {

    private UUID id;

    private String name;

    /**
     * Default constructor
     *
     * @deprecated Use {@link LicenceTypePatch#LicenceTypePatch(UUID, String)}
     */
    @Deprecated
    public LicenceTypePatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public LicenceTypePatch(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public LicenceTypePatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The licence type id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The licence type id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LicenceTypePatch name(String name) {
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
        LicenceTypePatch licenceTypePatch = (LicenceTypePatch) o;
        return Objects.equals(this.id, licenceTypePatch.id) &&
                Objects.equals(this.name, licenceTypePatch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LicenceTypePatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

