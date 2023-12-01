package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The booking window for a service
 */

@Schema(name = "BookingWindow", description = "The booking window for a service")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class BookingWindow {

    private BigDecimal max;

    private BigDecimal min;

    /**
     * Default constructor
     *
     * @deprecated Use {@link BookingWindow#BookingWindow(BigDecimal, BigDecimal)}
     */
    @Deprecated
    public BookingWindow() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public BookingWindow(BigDecimal max, BigDecimal min) {
        this.max = max;
        this.min = min;
    }

    public BookingWindow max(BigDecimal max) {
        this.max = max;
        return this;
    }

    /**
     * The max number of days before service in which it will be possible to book
     *
     * @return max
     */
    @NotNull
    @Valid
    @Schema(name = "max", description = "The max number of days before service in which it will be possible to book", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("max")
    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BookingWindow min(BigDecimal min) {
        this.min = min;
        return this;
    }

    /**
     * The minimum number of days before service in which it will be possible to book
     *
     * @return min
     */
    @NotNull
    @Valid
    @Schema(name = "min", description = "The minimum number of days before service in which it will be possible to book", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("min")
    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookingWindow bookingWindow = (BookingWindow) o;
        return Objects.equals(this.max, bookingWindow.max) &&
                Objects.equals(this.min, bookingWindow.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BookingWindow {\n");
        sb.append("    max: ").append(toIndentedString(max)).append("\n");
        sb.append("    min: ").append(toIndentedString(min)).append("\n");
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

