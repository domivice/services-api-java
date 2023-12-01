package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The new service category
 */

@Schema(name = "ServiceCategoryCreate", description = "The new service category")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceCategoryCreate {

    private String name;

    private String parentId;

    private String description;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceCategoryCreate#ServiceCategoryCreate(String)}
     */
    @Deprecated
    public ServiceCategoryCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceCategoryCreate(String name) {
        this.name = name;
    }

    public ServiceCategoryCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The service category name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The service category name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceCategoryCreate parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * The service category parent Id
     *
     * @return parentId
     */

    @Schema(name = "parentId", description = "The service category parent Id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public ServiceCategoryCreate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The service category description
     *
     * @return description
     */

    @Schema(name = "description", description = "The service category description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceCategoryCreate serviceCategoryCreate = (ServiceCategoryCreate) o;
        return Objects.equals(this.name, serviceCategoryCreate.name) &&
                Objects.equals(this.parentId, serviceCategoryCreate.parentId) &&
                Objects.equals(this.description, serviceCategoryCreate.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentId, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceCategoryCreate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

