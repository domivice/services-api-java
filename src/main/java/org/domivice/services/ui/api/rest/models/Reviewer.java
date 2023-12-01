package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * The service reviewer object
 */

@Schema(name = "Reviewer", description = "The service reviewer object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class Reviewer {

    private UUID id;

    private String name;

    private String location;

    private Media avatar;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Reviewer#Reviewer(UUID, String)}
     */
    @Deprecated
    public Reviewer() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Reviewer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Reviewer id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The reviewer id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The reviewer id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Reviewer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The reviewer name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The reviewer name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reviewer location(String location) {
        this.location = location;
        return this;
    }

    /**
     * The reviewer location
     *
     * @return location
     */

    @Schema(name = "location", description = "The reviewer location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Reviewer avatar(Media avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * Get avatar
     *
     * @return avatar
     */
    @Valid
    @Schema(name = "avatar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("avatar")
    public Media getAvatar() {
        return avatar;
    }

    public void setAvatar(Media avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reviewer reviewer = (Reviewer) o;
        return Objects.equals(this.id, reviewer.id) &&
                Objects.equals(this.name, reviewer.name) &&
                Objects.equals(this.location, reviewer.location) &&
                Objects.equals(this.avatar, reviewer.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, avatar);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Reviewer {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
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

