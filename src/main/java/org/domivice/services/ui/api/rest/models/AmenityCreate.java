package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * A text block
 */

@Schema(name = "AmenityCreate", description = "A text block")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class AmenityCreate {

    private String name;

    private String icon;

    private String description;

    private UUID serviceCategoryId;

    /**
     * Default constructor
     *
     * @deprecated Use {@link AmenityCreate#AmenityCreate(String, String, UUID)}
     */
    @Deprecated
    public AmenityCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public AmenityCreate(String name, String icon, UUID serviceCategoryId) {
        this.name = name;
        this.icon = icon;
        this.serviceCategoryId = serviceCategoryId;
    }

    public AmenityCreate name(String name) {
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

    public AmenityCreate icon(String icon) {
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

    public AmenityCreate description(String description) {
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

    public AmenityCreate serviceCategoryId(UUID serviceCategoryId) {
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
        AmenityCreate amenityCreate = (AmenityCreate) o;
        return Objects.equals(this.name, amenityCreate.name) &&
                Objects.equals(this.icon, amenityCreate.icon) &&
                Objects.equals(this.description, amenityCreate.description) &&
                Objects.equals(this.serviceCategoryId, amenityCreate.serviceCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, description, serviceCategoryId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AmenityCreate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

