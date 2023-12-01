package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 *
 */

@Schema(name = "ServiceCategoryPatch", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceCategoryPatch {

    private UUID id;

    private String name;

    private UUID parentId;

    private String description;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceCategoryPatch#ServiceCategoryPatch(UUID)}
     */
    @Deprecated
    public ServiceCategoryPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceCategoryPatch(UUID id) {
        this.id = id;
    }

    public ServiceCategoryPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The service category id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The service category id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ServiceCategoryPatch name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The service category name
     *
     * @return name
     */

    @Schema(name = "name", description = "The service category name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceCategoryPatch parentId(UUID parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * The service category parent Id
     *
     * @return parentId
     */
    @Valid
    @Schema(name = "parentId", description = "The service category parent Id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("parentId")
    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public ServiceCategoryPatch description(String description) {
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
        ServiceCategoryPatch serviceCategoryPatch = (ServiceCategoryPatch) o;
        return Objects.equals(this.id, serviceCategoryPatch.id) &&
                Objects.equals(this.name, serviceCategoryPatch.name) &&
                Objects.equals(this.parentId, serviceCategoryPatch.parentId) &&
                Objects.equals(this.description, serviceCategoryPatch.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceCategoryPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

