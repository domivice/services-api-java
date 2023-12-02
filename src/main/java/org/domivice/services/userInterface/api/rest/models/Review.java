package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * The service review
 */

@Schema(name = "Review", description = "The service review")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class Review {

    private UUID id;

    private String review;

    private Float rating;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime reviewDate;

    private Reviewer reviewer;

    private UUID parentId;

    private ServiceSummary service;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Review#Review(UUID, String, Float, OffsetDateTime, Reviewer, ServiceSummary)}
     */
    @Deprecated
    public Review() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Review(UUID id, String review, Float rating, OffsetDateTime reviewDate, Reviewer reviewer, ServiceSummary service) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.reviewer = reviewer;
        this.service = service;
    }

    public Review id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The review id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The review id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Review review(String review) {
        this.review = review;
        return this;
    }

    /**
     * The review text
     *
     * @return review
     */
    @NotNull
    @Schema(name = "review", description = "The review text", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Review rating(Float rating) {
        this.rating = rating;
        return this;
    }

    /**
     * The review rating
     *
     * @return rating
     */
    @NotNull
    @Schema(name = "rating", description = "The review rating", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("rating")
    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Review reviewDate(OffsetDateTime reviewDate) {
        this.reviewDate = reviewDate;
        return this;
    }

    /**
     * The review date
     *
     * @return reviewDate
     */
    @NotNull
    @Valid
    @Schema(name = "reviewDate", description = "The review date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("reviewDate")
    public OffsetDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(OffsetDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Review reviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    /**
     * Get reviewer
     *
     * @return reviewer
     */
    @NotNull
    @Valid
    @Schema(name = "reviewer", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("reviewer")
    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Review parentId(UUID parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * The review parent id
     *
     * @return parentId
     */
    @Valid
    @Schema(name = "parentId", description = "The review parent id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("parentId")
    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public Review service(ServiceSummary service) {
        this.service = service;
        return this;
    }

    /**
     * Get service
     *
     * @return service
     */
    @NotNull
    @Valid
    @Schema(name = "service", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("service")
    public ServiceSummary getService() {
        return service;
    }

    public void setService(ServiceSummary service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equals(this.id, review.id) &&
                Objects.equals(this.review, review.review) &&
                Objects.equals(this.rating, review.rating) &&
                Objects.equals(this.reviewDate, review.reviewDate) &&
                Objects.equals(this.reviewer, review.reviewer) &&
                Objects.equals(this.parentId, review.parentId) &&
                Objects.equals(this.service, review.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, rating, reviewDate, reviewer, parentId, service);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Review {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    review: ").append(toIndentedString(review)).append("\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    reviewDate: ").append(toIndentedString(reviewDate)).append("\n");
        sb.append("    reviewer: ").append(toIndentedString(reviewer)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

