package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The day schedule
 */

@Schema(name = "DaySchedule", description = "The day schedule ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class DaySchedule {

    private DayOfWeekEnum dayOfWeek;
    @Valid
    private List<@Valid TimeSlot> timeSlots = new ArrayList<>();
    private Boolean isOpen;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DaySchedule#DaySchedule(DayOfWeekEnum, List<@Valid TimeSlot>, Boolean)}
     */
    @Deprecated
    public DaySchedule() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DaySchedule(DayOfWeekEnum dayOfWeek, List<@Valid TimeSlot> timeSlots, Boolean isOpen) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlots = timeSlots;
        this.isOpen = isOpen;
    }

    public DaySchedule dayOfWeek(DayOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * The day of week
     *
     * @return dayOfWeek
     */
    @NotNull
    @Schema(name = "dayOfWeek", description = "The day of week", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("dayOfWeek")
    public DayOfWeekEnum getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public DaySchedule timeSlots(List<@Valid TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
        return this;
    }

    public DaySchedule addTimeSlotsItem(TimeSlot timeSlotsItem) {
        if (this.timeSlots == null) {
            this.timeSlots = new ArrayList<>();
        }
        this.timeSlots.add(timeSlotsItem);
        return this;
    }

    /**
     * The day schedule time slots
     *
     * @return timeSlots
     */
    @NotNull
    @Valid
    @Schema(name = "timeSlots", description = "The day schedule time slots", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("timeSlots")
    public List<@Valid TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<@Valid TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public DaySchedule isOpen(Boolean isOpen) {
        this.isOpen = isOpen;
        return this;
    }

    /**
     * Is the service open for the day
     *
     * @return isOpen
     */
    @NotNull
    @Schema(name = "isOpen", description = "Is the service open for the day", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("isOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DaySchedule daySchedule = (DaySchedule) o;
        return Objects.equals(this.dayOfWeek, daySchedule.dayOfWeek) &&
                Objects.equals(this.timeSlots, daySchedule.timeSlots) &&
                Objects.equals(this.isOpen, daySchedule.isOpen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, timeSlots, isOpen);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DaySchedule {\n");
        sb.append("    dayOfWeek: ").append(toIndentedString(dayOfWeek)).append("\n");
        sb.append("    timeSlots: ").append(toIndentedString(timeSlots)).append("\n");
        sb.append("    isOpen: ").append(toIndentedString(isOpen)).append("\n");
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
     * The day of week
     */
    public enum DayOfWeekEnum {
        MON("mon"),

        TUE("tue"),

        WED("wed"),

        THU("thu"),

        FRI("fri"),

        SAT("sat"),

        SUN("sun"),

        HOLIDAY("holiday");

        private String value;

        DayOfWeekEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static DayOfWeekEnum fromValue(String value) {
            for (DayOfWeekEnum b : DayOfWeekEnum.values()) {
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

