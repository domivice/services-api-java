package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */

@Schema(name = "ServiceProviderList", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class ServiceProviderList {

    @Valid
    private List<@Valid ServiceProviderSummary> data = new ArrayList<>();

    private String nextPage;

    private BigDecimal pageCount;

    private String previousPage;

    private BigDecimal totalItemsCount;

    /**
     * Default constructor
     *
     * @deprecated Use {@link ServiceProviderList#ServiceProviderList(List<@Valid ServiceProviderSummary>, String, BigDecimal, String, BigDecimal)}
     */
    @Deprecated
    public ServiceProviderList() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public ServiceProviderList(List<@Valid ServiceProviderSummary> data, String nextPage, BigDecimal pageCount, String previousPage, BigDecimal totalItemsCount) {
        this.data = data;
        this.nextPage = nextPage;
        this.pageCount = pageCount;
        this.previousPage = previousPage;
        this.totalItemsCount = totalItemsCount;
    }

    public ServiceProviderList data(List<@Valid ServiceProviderSummary> data) {
        this.data = data;
        return this;
    }

    public ServiceProviderList addDataItem(ServiceProviderSummary dataItem) {
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
    public List<@Valid ServiceProviderSummary> getData() {
        return data;
    }

    public void setData(List<@Valid ServiceProviderSummary> data) {
        this.data = data;
    }

    public ServiceProviderList nextPage(String nextPage) {
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

    public ServiceProviderList pageCount(BigDecimal pageCount) {
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

    public ServiceProviderList previousPage(String previousPage) {
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

    public ServiceProviderList totalItemsCount(BigDecimal totalItemsCount) {
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
        ServiceProviderList serviceProviderList = (ServiceProviderList) o;
        return Objects.equals(this.data, serviceProviderList.data) &&
                Objects.equals(this.nextPage, serviceProviderList.nextPage) &&
                Objects.equals(this.pageCount, serviceProviderList.pageCount) &&
                Objects.equals(this.previousPage, serviceProviderList.previousPage) &&
                Objects.equals(this.totalItemsCount, serviceProviderList.totalItemsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nextPage, pageCount, previousPage, totalItemsCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceProviderList {\n");
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

