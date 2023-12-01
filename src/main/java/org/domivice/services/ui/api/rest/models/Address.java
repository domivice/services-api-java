package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 */

@Schema(name = "Address", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class Address {

    private String city;

    private String country;

    private String postalCode;

    private String state;

    private String street;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Address#Address(String, String, String, String, String)}
     */
    @Deprecated
    public Address() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Address(String city, String country, String postalCode, String state, String street) {
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
        this.street = street;
    }

    public Address city(String city) {
        this.city = city;
        return this;
    }

    /**
     * The city
     *
     * @return city
     */
    @NotNull
    @Schema(name = "city", description = "The city", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address country(String country) {
        this.country = country;
        return this;
    }

    /**
     * The country
     *
     * @return country
     */
    @NotNull
    @Schema(name = "country", description = "The country", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * The postal code
     *
     * @return postalCode
     */
    @NotNull
    @Schema(name = "postalCode", description = "The postal code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address state(String state) {
        this.state = state;
        return this;
    }

    /**
     * The state or province
     *
     * @return state
     */
    @NotNull
    @Schema(name = "state", description = "The state or province ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    /**
     * The street part of the address
     *
     * @return street
     */
    @NotNull
    @Schema(name = "street", description = "The street part of the address", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.city, address.city) &&
                Objects.equals(this.country, address.country) &&
                Objects.equals(this.postalCode, address.postalCode) &&
                Objects.equals(this.state, address.state) &&
                Objects.equals(this.street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, postalCode, state, street);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
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

