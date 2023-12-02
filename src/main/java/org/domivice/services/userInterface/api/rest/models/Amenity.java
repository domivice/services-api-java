package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Objects;
import java.util.UUID;

/**
 * A text block
 */

@Schema(name = "Amenity", description = "A text block")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class Amenity {

    private String name;

    private String icon;

    private String description;

    private UUID id;

    private UUID serviceCategoryId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Amenity#Amenity(String, String, UUID, UUID)}
     */
    @Deprecated
    public Amenity() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Amenity(String name, String icon, UUID id, UUID serviceCategoryId) {
        this.name = name;
        this.icon = icon;
        this.id = id;
        this.serviceCategoryId = serviceCategoryId;
    }

    public Amenity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The amenity title
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The amenity title", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amenity icon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * The amenity icon
     *
     * @return icon
     */
    @NotNull
    @Schema(name = "icon", description = "The amenity icon", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Amenity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The amenity description
     *
     * @return description
     */

    @Schema(name = "description", description = "The amenity description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amenity id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The amenity id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The amenity id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Amenity serviceCategoryId(UUID serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
        return this;
    }

    /**
     * The amenity service category id
     *
     * @return serviceCategoryId
     */
    @NotNull
    @Valid
    @Schema(name = "serviceCategoryId", description = "The amenity service category id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("serviceCategoryId")
    public UUID getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(UUID serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Amenity amenity = (Amenity) o;
        return Objects.equals(this.name, amenity.name) &&
                Objects.equals(this.icon, amenity.icon) &&
                Objects.equals(this.description, amenity.description) &&
                Objects.equals(this.id, amenity.id) &&
                Objects.equals(this.serviceCategoryId, amenity.serviceCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, description, id, serviceCategoryId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Amenity {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
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

