package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Objects;
import java.util.UUID;

/**
 * The service provider object
 */

@Schema(name = "ServiceProviderPatch", description = "The service provider object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class ServiceProviderPatch {

    private UUID id;

    private String bio;

    private ServiceProviderStatus status;

    private String cityCode;

    private String countryCode;

    private String stateCode;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceProviderPatch#ServiceProviderPatch(UUID)}
     */
    @Deprecated
    public ServiceProviderPatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceProviderPatch(UUID id) {
        this.id = id;
    }

    public ServiceProviderPatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The service provider user id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The service provider user id ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ServiceProviderPatch bio(String bio) {
        this.bio = bio;
        return this;
    }

    /**
     * The service provider bio
     *
     * @return bio
     */

    @Schema(name = "bio", description = "The service provider bio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("bio")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ServiceProviderPatch status(ServiceProviderStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @Valid
    @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public ServiceProviderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceProviderStatus status) {
        this.status = status;
    }

    public ServiceProviderPatch cityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    /**
     * The service provider city code
     *
     * @return cityCode
     */

    @Schema(name = "cityCode", description = "The service provider city code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("cityCode")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public ServiceProviderPatch countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The service provider country code
     *
     * @return countryCode
     */

    @Schema(name = "countryCode", description = "The service provider country code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public ServiceProviderPatch stateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    /**
     * The service provider state code
     *
     * @return stateCode
     */

    @Schema(name = "stateCode", description = "The service provider state code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("stateCode")
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceProviderPatch serviceProviderPatch = (ServiceProviderPatch) o;
        return Objects.equals(this.id, serviceProviderPatch.id) &&
                Objects.equals(this.bio, serviceProviderPatch.bio) &&
                Objects.equals(this.status, serviceProviderPatch.status) &&
                Objects.equals(this.cityCode, serviceProviderPatch.cityCode) &&
                Objects.equals(this.countryCode, serviceProviderPatch.countryCode) &&
                Objects.equals(this.stateCode, serviceProviderPatch.stateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bio, status, cityCode, countryCode, stateCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceProviderPatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    cityCode: ").append(toIndentedString(cityCode)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
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

