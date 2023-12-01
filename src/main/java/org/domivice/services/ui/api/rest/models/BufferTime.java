package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The service booking buffer time
 */

@Schema(name = "BufferTime", description = "The service booking buffer time")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class BufferTime {

    private BigDecimal before;

    private BigDecimal after;

    /**
     * Default constructor
     *
     * @deprecated Use {@link BufferTime#BufferTime(BigDecimal, BigDecimal)}
     */
    @Deprecated
    public BufferTime() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public BufferTime(BigDecimal before, BigDecimal after) {
        this.before = before;
        this.after = after;
    }

    public BufferTime before(BigDecimal before) {
        this.before = before;
        return this;
    }

    /**
     * Before time before in minutes
     *
     * @return before
     */
    @NotNull
    @Valid
    @Schema(name = "before", description = "Before time before in minutes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("before")
    public BigDecimal getBefore() {
        return before;
    }

    public void setBefore(BigDecimal before) {
        this.before = before;
    }

    public BufferTime after(BigDecimal after) {
        this.after = after;
        return this;
    }

    /**
     * The buffer time after in minutes
     *
     * @return after
     */
    @NotNull
    @Valid
    @Schema(name = "after", description = "The buffer time after in minutes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("after")
    public BigDecimal getAfter() {
        return after;
    }

    public void setAfter(BigDecimal after) {
        this.after = after;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BufferTime bufferTime = (BufferTime) o;
        return Objects.equals(this.before, bufferTime.before) &&
                Objects.equals(this.after, bufferTime.after);
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, after);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BufferTime {\n");
        sb.append("    before: ").append(toIndentedString(before)).append("\n");
        sb.append("    after: ").append(toIndentedString(after)).append("\n");
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

