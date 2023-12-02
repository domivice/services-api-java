package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;

import java.util.Objects;

/**
 * The time slot part of the service schedule
 */

@Schema(name = "TimeSlot", description = "The time slot part of the service schedule")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class TimeSlot {

    private String startTime;

    private String endTime;

    /**
     * Default constructor
     *
     * @deprecated Use {@link TimeSlot#TimeSlot(String, String)}
     */
    @Deprecated
    public TimeSlot() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeSlot startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * The start time
     *
     * @return startTime
     */
    @NotNull
    @Schema(name = "startTime", description = "The start time", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public TimeSlot endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * The end time
     *
     * @return endTime
     */
    @NotNull
    @Schema(name = "endTime", description = "The end time ", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("endTime")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(this.startTime, timeSlot.startTime) &&
                Objects.equals(this.endTime, timeSlot.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TimeSlot {\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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

