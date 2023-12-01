package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The cancellation policy
 */

@Schema(name = "CancellationPolicy", description = "The cancellation policy")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class CancellationPolicy {

    private String policyText;

    private BigDecimal cancellationDeadline;

    private Integer refundPercentage;

    /**
     * Default constructor
     *
     * @deprecated Use {@link CancellationPolicy#CancellationPolicy(String, BigDecimal, Integer)}
     */
    @Deprecated
    public CancellationPolicy() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public CancellationPolicy(String policyText, BigDecimal cancellationDeadline, Integer refundPercentage) {
        this.policyText = policyText;
        this.cancellationDeadline = cancellationDeadline;
        this.refundPercentage = refundPercentage;
    }

    public CancellationPolicy policyText(String policyText) {
        this.policyText = policyText;
        return this;
    }

    /**
     * The cancellation policy text
     *
     * @return policyText
     */
    @NotNull
    @Schema(name = "policyText", description = "The cancellation policy text", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("policyText")
    public String getPolicyText() {
        return policyText;
    }

    public void setPolicyText(String policyText) {
        this.policyText = policyText;
    }

    public CancellationPolicy cancellationDeadline(BigDecimal cancellationDeadline) {
        this.cancellationDeadline = cancellationDeadline;
        return this;
    }

    /**
     * The numbers of days before the service date.
     *
     * @return cancellationDeadline
     */
    @NotNull
    @Valid
    @Schema(name = "cancellationDeadline", description = "The numbers of days before the service date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("cancellationDeadline")
    public BigDecimal getCancellationDeadline() {
        return cancellationDeadline;
    }

    public void setCancellationDeadline(BigDecimal cancellationDeadline) {
        this.cancellationDeadline = cancellationDeadline;
    }

    public CancellationPolicy refundPercentage(Integer refundPercentage) {
        this.refundPercentage = refundPercentage;
        return this;
    }

    /**
     * The refund percentage
     *
     * @return refundPercentage
     */
    @NotNull
    @Schema(name = "refundPercentage", description = "The refund percentage", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("refundPercentage")
    public Integer getRefundPercentage() {
        return refundPercentage;
    }

    public void setRefundPercentage(Integer refundPercentage) {
        this.refundPercentage = refundPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CancellationPolicy cancellationPolicy = (CancellationPolicy) o;
        return Objects.equals(this.policyText, cancellationPolicy.policyText) &&
                Objects.equals(this.cancellationDeadline, cancellationPolicy.cancellationDeadline) &&
                Objects.equals(this.refundPercentage, cancellationPolicy.refundPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyText, cancellationDeadline, refundPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CancellationPolicy {\n");
        sb.append("    policyText: ").append(toIndentedString(policyText)).append("\n");
        sb.append("    cancellationDeadline: ").append(toIndentedString(cancellationDeadline)).append("\n");
        sb.append("    refundPercentage: ").append(toIndentedString(refundPercentage)).append("\n");
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

