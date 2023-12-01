package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * The service provider object
 */

@Schema(name = "ServiceProviderSummary", description = "The service provider object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceProviderSummary {

    private UUID id;

    private BigDecimal reviewCount;

    private String badge;

    private String bio;

    private Float rating;

    private String geohash;

    private String firstName;

    private String lastName;
    private StatusEnum status;
    private Country country;
    private State state;
    private City city;
    private Media avatar;
    private String slug;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceProviderSummary#ServiceProviderSummary(UUID, String)}
     */
    @Deprecated
    public ServiceProviderSummary() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceProviderSummary(UUID id, String slug) {
        this.id = id;
        this.slug = slug;
    }

    public ServiceProviderSummary id(UUID id) {
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

    public ServiceProviderSummary reviewCount(BigDecimal reviewCount) {
        this.reviewCount = reviewCount;
        return this;
    }

    /**
     * The service provider review count
     *
     * @return reviewCount
     */
    @Valid
    @Schema(name = "reviewCount", description = "The service provider review count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("reviewCount")
    public BigDecimal getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(BigDecimal reviewCount) {
        this.reviewCount = reviewCount;
    }

    public ServiceProviderSummary badge(String badge) {
        this.badge = badge;
        return this;
    }

    /**
     * The service provider badge
     *
     * @return badge
     */

    @Schema(name = "badge", description = "The service provider badge", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("badge")
    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public ServiceProviderSummary bio(String bio) {
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

    public ServiceProviderSummary rating(Float rating) {
        this.rating = rating;
        return this;
    }

    /**
     * The service provider rating
     *
     * @return rating
     */

    @Schema(name = "rating", description = "The service provider rating", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("rating")
    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public ServiceProviderSummary geohash(String geohash) {
        this.geohash = geohash;
        return this;
    }

    /**
     * The service provider geohash
     *
     * @return geohash
     */

    @Schema(name = "geohash", description = "The service provider geohash", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("geohash")
    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public ServiceProviderSummary firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The service provider name
     *
     * @return firstName
     */

    @Schema(name = "firstName", description = "The service provider name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ServiceProviderSummary lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The service provider last name
     *
     * @return lastName
     */

    @Schema(name = "lastName", description = "The service provider last name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ServiceProviderSummary status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Specifies the service provider status
     *
     * @return status
     */

    @Schema(name = "status", description = "Specifies the service provider status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ServiceProviderSummary country(Country country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
     */
    @Valid
    @Schema(name = "country", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ServiceProviderSummary state(State state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     */
    @Valid
    @Schema(name = "state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ServiceProviderSummary city(City city) {
        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
     */
    @Valid
    @Schema(name = "city", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ServiceProviderSummary avatar(Media avatar) {
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

    public ServiceProviderSummary slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The service provider slug
     *
     * @return slug
     */
    @NotNull
    @Schema(name = "slug", description = "The service provider slug", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceProviderSummary serviceProviderSummary = (ServiceProviderSummary) o;
        return Objects.equals(this.id, serviceProviderSummary.id) &&
                Objects.equals(this.reviewCount, serviceProviderSummary.reviewCount) &&
                Objects.equals(this.badge, serviceProviderSummary.badge) &&
                Objects.equals(this.bio, serviceProviderSummary.bio) &&
                Objects.equals(this.rating, serviceProviderSummary.rating) &&
                Objects.equals(this.geohash, serviceProviderSummary.geohash) &&
                Objects.equals(this.firstName, serviceProviderSummary.firstName) &&
                Objects.equals(this.lastName, serviceProviderSummary.lastName) &&
                Objects.equals(this.status, serviceProviderSummary.status) &&
                Objects.equals(this.country, serviceProviderSummary.country) &&
                Objects.equals(this.state, serviceProviderSummary.state) &&
                Objects.equals(this.city, serviceProviderSummary.city) &&
                Objects.equals(this.avatar, serviceProviderSummary.avatar) &&
                Objects.equals(this.slug, serviceProviderSummary.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewCount, badge, bio, rating, geohash, firstName, lastName, status, country, state, city, avatar, slug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceProviderSummary {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    reviewCount: ").append(toIndentedString(reviewCount)).append("\n");
        sb.append("    badge: ").append(toIndentedString(badge)).append("\n");
        sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    geohash: ").append(toIndentedString(geohash)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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

    /**
     * Specifies the service provider status
     */
    public enum StatusEnum {
        ACTIVE("active"),

        INACTIVE("inactive");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
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
}

