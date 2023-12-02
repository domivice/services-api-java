package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The service provider object
 */

@Schema(name = "ServiceProvider", description = "The service provider object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class ServiceProvider {

    private UUID id;

    private BigDecimal reviewCount;

    private String badge;

    private String bio;

    @Valid
    private List<String> languages;

    private Float rating;

    private String geohash;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Address address;

    @Valid
    private List<@Valid BlockedDate> blockedDates = new ArrayList<>();

    private ServiceProviderStatus status;

    private Country country;

    private State state;

    private City city;

    private Media avatar;

    private String slug;

    private ServiceProviderResponseRate responseRate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime lastActivity;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime firstActivity;

    @Valid
    private List<@Valid Certification> certifications;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceProvider#ServiceProvider(UUID, BigDecimal, String, List<@Valid BlockedDate>, ServiceProviderStatus, Country, State, City, String, OffsetDateTime, OffsetDateTime)}
     */
    @Deprecated
    public ServiceProvider() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceProvider(UUID id, BigDecimal reviewCount, String geohash, List<@Valid BlockedDate> blockedDates, ServiceProviderStatus status, Country country, State state, City city, String slug, OffsetDateTime lastActivity, OffsetDateTime firstActivity) {
        this.id = id;
        this.reviewCount = reviewCount;
        this.geohash = geohash;
        this.blockedDates = blockedDates;
        this.status = status;
        this.country = country;
        this.state = state;
        this.city = city;
        this.slug = slug;
        this.lastActivity = lastActivity;
        this.firstActivity = firstActivity;
    }

    public ServiceProvider id(UUID id) {
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

    public ServiceProvider reviewCount(BigDecimal reviewCount) {
        this.reviewCount = reviewCount;
        return this;
    }

    /**
     * The service provider review count
     *
     * @return reviewCount
     */
    @NotNull
    @Valid
    @Schema(name = "reviewCount", description = "The service provider review count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("reviewCount")
    public BigDecimal getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(BigDecimal reviewCount) {
        this.reviewCount = reviewCount;
    }

    public ServiceProvider badge(String badge) {
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

    public ServiceProvider bio(String bio) {
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

    public ServiceProvider languages(List<String> languages) {
        this.languages = languages;
        return this;
    }

    public ServiceProvider addLanguagesItem(String languagesItem) {
        if (this.languages == null) {
            this.languages = new ArrayList<>();
        }
        this.languages.add(languagesItem);
        return this;
    }

    /**
     * The service provider languages
     *
     * @return languages
     */

    @Schema(name = "languages", description = "The service provider languages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public ServiceProvider rating(Float rating) {
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

    public ServiceProvider geohash(String geohash) {
        this.geohash = geohash;
        return this;
    }

    /**
     * The service provider geohash
     *
     * @return geohash
     */
    @NotNull
    @Schema(name = "geohash", description = "The service provider geohash", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("geohash")
    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public ServiceProvider firstName(String firstName) {
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

    public ServiceProvider lastName(String lastName) {
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

    public ServiceProvider email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The service provider email address
     *
     * @return email
     */

    @Schema(name = "email", description = "The service provider email address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ServiceProvider phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * The service provider phone number
     *
     * @return phoneNumber
     */

    @Schema(name = "phoneNumber", description = "The service provider phone number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ServiceProvider address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     */
    @Valid
    @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ServiceProvider blockedDates(List<@Valid BlockedDate> blockedDates) {
        this.blockedDates = blockedDates;
        return this;
    }

    public ServiceProvider addBlockedDatesItem(BlockedDate blockedDatesItem) {
        if (this.blockedDates == null) {
            this.blockedDates = new ArrayList<>();
        }
        this.blockedDates.add(blockedDatesItem);
        return this;
    }

    /**
     * The provider blocked dates
     *
     * @return blockedDates
     */
    @NotNull
    @Valid
    @Schema(name = "blockedDates", description = "The provider blocked dates", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("blockedDates")
    public List<@Valid BlockedDate> getBlockedDates() {
        return blockedDates;
    }

    public void setBlockedDates(List<@Valid BlockedDate> blockedDates) {
        this.blockedDates = blockedDates;
    }

    public ServiceProvider status(ServiceProviderStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @NotNull
    @Valid
    @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("status")
    public ServiceProviderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceProviderStatus status) {
        this.status = status;
    }

    public ServiceProvider country(Country country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
     */
    @NotNull
    @Valid
    @Schema(name = "country", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ServiceProvider state(State state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     */
    @NotNull
    @Valid
    @Schema(name = "state", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("state")
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ServiceProvider city(City city) {
        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
     */
    @NotNull
    @Valid
    @Schema(name = "city", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ServiceProvider avatar(Media avatar) {
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

    public ServiceProvider slug(String slug) {
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

    public ServiceProvider responseRate(ServiceProviderResponseRate responseRate) {
        this.responseRate = responseRate;
        return this;
    }

    /**
     * Get responseRate
     *
     * @return responseRate
     */
    @Valid
    @Schema(name = "responseRate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("responseRate")
    public ServiceProviderResponseRate getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(ServiceProviderResponseRate responseRate) {
        this.responseRate = responseRate;
    }

    public ServiceProvider lastActivity(OffsetDateTime lastActivity) {
        this.lastActivity = lastActivity;
        return this;
    }

    /**
     * The service provider last activity
     *
     * @return lastActivity
     */
    @NotNull
    @Valid
    @Schema(name = "lastActivity", description = "The service provider last activity", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("lastActivity")
    public OffsetDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(OffsetDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    public ServiceProvider firstActivity(OffsetDateTime firstActivity) {
        this.firstActivity = firstActivity;
        return this;
    }

    /**
     * The service provider first activity
     *
     * @return firstActivity
     */
    @NotNull
    @Valid
    @Schema(name = "firstActivity", description = "The service provider first activity", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("firstActivity")
    public OffsetDateTime getFirstActivity() {
        return firstActivity;
    }

    public void setFirstActivity(OffsetDateTime firstActivity) {
        this.firstActivity = firstActivity;
    }

    public ServiceProvider certifications(List<@Valid Certification> certifications) {
        this.certifications = certifications;
        return this;
    }

    public ServiceProvider addCertificationsItem(Certification certificationsItem) {
        if (this.certifications == null) {
            this.certifications = new ArrayList<>();
        }
        this.certifications.add(certificationsItem);
        return this;
    }

    /**
     * The service provider certifications
     *
     * @return certifications
     */
    @Valid
    @Schema(name = "certifications", description = "The service provider certifications", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("certifications")
    public List<@Valid Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<@Valid Certification> certifications) {
        this.certifications = certifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceProvider serviceProvider = (ServiceProvider) o;
        return Objects.equals(this.id, serviceProvider.id) &&
                Objects.equals(this.reviewCount, serviceProvider.reviewCount) &&
                Objects.equals(this.badge, serviceProvider.badge) &&
                Objects.equals(this.bio, serviceProvider.bio) &&
                Objects.equals(this.languages, serviceProvider.languages) &&
                Objects.equals(this.rating, serviceProvider.rating) &&
                Objects.equals(this.geohash, serviceProvider.geohash) &&
                Objects.equals(this.firstName, serviceProvider.firstName) &&
                Objects.equals(this.lastName, serviceProvider.lastName) &&
                Objects.equals(this.email, serviceProvider.email) &&
                Objects.equals(this.phoneNumber, serviceProvider.phoneNumber) &&
                Objects.equals(this.address, serviceProvider.address) &&
                Objects.equals(this.blockedDates, serviceProvider.blockedDates) &&
                Objects.equals(this.status, serviceProvider.status) &&
                Objects.equals(this.country, serviceProvider.country) &&
                Objects.equals(this.state, serviceProvider.state) &&
                Objects.equals(this.city, serviceProvider.city) &&
                Objects.equals(this.avatar, serviceProvider.avatar) &&
                Objects.equals(this.slug, serviceProvider.slug) &&
                Objects.equals(this.responseRate, serviceProvider.responseRate) &&
                Objects.equals(this.lastActivity, serviceProvider.lastActivity) &&
                Objects.equals(this.firstActivity, serviceProvider.firstActivity) &&
                Objects.equals(this.certifications, serviceProvider.certifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewCount, badge, bio, languages, rating, geohash, firstName, lastName, email, phoneNumber, address, blockedDates, status, country, state, city, avatar, slug, responseRate, lastActivity, firstActivity, certifications);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceProvider {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    reviewCount: ").append(toIndentedString(reviewCount)).append("\n");
        sb.append("    badge: ").append(toIndentedString(badge)).append("\n");
        sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
        sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    geohash: ").append(toIndentedString(geohash)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    blockedDates: ").append(toIndentedString(blockedDates)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    responseRate: ").append(toIndentedString(responseRate)).append("\n");
        sb.append("    lastActivity: ").append(toIndentedString(lastActivity)).append("\n");
        sb.append("    firstActivity: ").append(toIndentedString(firstActivity)).append("\n");
        sb.append("    certifications: ").append(toIndentedString(certifications)).append("\n");
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

