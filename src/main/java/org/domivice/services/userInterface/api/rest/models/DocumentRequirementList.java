package org.domivice.services.userInterface.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */

@Schema(name = "DocumentRequirementList", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-02T14:34:00.627762-05:00[America/Toronto]")
public class DocumentRequirementList {

    @Valid
    private List<@Valid DocumentRequirement> data = new ArrayList<>();

    private String nextPage;

    private BigDecimal pageCount;

    private String previousPage;

    private BigDecimal totalItemsCount;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentRequirementList#DocumentRequirementList(List<@Valid DocumentRequirement>, String, BigDecimal, String, BigDecimal)}
     */
    @Deprecated
    public DocumentRequirementList() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentRequirementList(List<@Valid DocumentRequirement> data, String nextPage, BigDecimal pageCount, String previousPage, BigDecimal totalItemsCount) {
        this.data = data;
        this.nextPage = nextPage;
        this.pageCount = pageCount;
        this.previousPage = previousPage;
        this.totalItemsCount = totalItemsCount;
    }

    public DocumentRequirementList data(List<@Valid DocumentRequirement> data) {
        this.data = data;
        return this;
    }

    public DocumentRequirementList addDataItem(DocumentRequirement dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * The list of items in current page
     *
     * @return data
     */
    @NotNull
    @Valid
    @Schema(name = "data", description = "The list of items in current page", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("data")
    public List<@Valid DocumentRequirement> getData() {
        return data;
    }

    public void setData(List<@Valid DocumentRequirement> data) {
        this.data = data;
    }

    public DocumentRequirementList nextPage(String nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    /**
     * The URL to access the next page
     *
     * @return nextPage
     */
    @NotNull
    @Schema(name = "nextPage", description = "The URL to access the next page", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("nextPage")
    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public DocumentRequirementList pageCount(BigDecimal pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    /**
     * The page count
     *
     * @return pageCount
     */
    @NotNull
    @Valid
    @Schema(name = "pageCount", description = "The page count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("pageCount")
    public BigDecimal getPageCount() {
        return pageCount;
    }

    public void setPageCount(BigDecimal pageCount) {
        this.pageCount = pageCount;
    }

    public DocumentRequirementList previousPage(String previousPage) {
        this.previousPage = previousPage;
        return this;
    }

    /**
     * The URL to access the previous page
     *
     * @return previousPage
     */
    @NotNull
    @Schema(name = "previousPage", description = "The URL to access the previous page", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("previousPage")
    public String getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }

    public DocumentRequirementList totalItemsCount(BigDecimal totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
        return this;
    }

    /**
     * The total number of items in the database
     *
     * @return totalItemsCount
     */
    @NotNull
    @Valid
    @Schema(name = "totalItemsCount", description = "The total number of items in the database", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("totalItemsCount")
    public BigDecimal getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(BigDecimal totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentRequirementList documentRequirementList = (DocumentRequirementList) o;
        return Objects.equals(this.data, documentRequirementList.data) &&
                Objects.equals(this.nextPage, documentRequirementList.nextPage) &&
                Objects.equals(this.pageCount, documentRequirementList.pageCount) &&
                Objects.equals(this.previousPage, documentRequirementList.previousPage) &&
                Objects.equals(this.totalItemsCount, documentRequirementList.totalItemsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nextPage, pageCount, previousPage, totalItemsCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentRequirementList {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    nextPage: ").append(toIndentedString(nextPage)).append("\n");
        sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
        sb.append("    previousPage: ").append(toIndentedString(previousPage)).append("\n");
        sb.append("    totalItemsCount: ").append(toIndentedString(totalItemsCount)).append("\n");
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

