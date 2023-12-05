package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.domivice.services.web.api.rest.models.ServiceCategory;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * 
 */

@Schema(name = "ServiceCategoryList", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class ServiceCategoryList {

  @Valid
  private List<@Valid ServiceCategory> data = new ArrayList<>();

  private String nextPage;

  private Integer pageCount;

  private String previousPage;

  private Integer totalItemsCount;

  /**
   * Default constructor
   * @deprecated Use {@link ServiceCategoryList#ServiceCategoryList(List<@Valid ServiceCategory>, String, Integer, String, Integer)}
   */
  @Deprecated
  public ServiceCategoryList() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ServiceCategoryList(List<@Valid ServiceCategory> data, String nextPage, Integer pageCount, String previousPage, Integer totalItemsCount) {
    this.data = data;
    this.nextPage = nextPage;
    this.pageCount = pageCount;
    this.previousPage = previousPage;
    this.totalItemsCount = totalItemsCount;
  }

  public ServiceCategoryList data(List<@Valid ServiceCategory> data) {
    this.data = data;
    return this;
  }

  public ServiceCategoryList addDataItem(ServiceCategory dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * The list of items in current page
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", description = "The list of items in current page", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid ServiceCategory> getData() {
    return data;
  }

  public void setData(List<@Valid ServiceCategory> data) {
    this.data = data;
  }

  public ServiceCategoryList nextPage(String nextPage) {
    this.nextPage = nextPage;
    return this;
  }

  /**
   * The URL to access the next page
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

  public ServiceCategoryList pageCount(Integer pageCount) {
    this.pageCount = pageCount;
    return this;
  }

  /**
   * The page count
   * @return pageCount
  */
  @NotNull 
  @Schema(name = "pageCount", description = "The page count", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageCount")
  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public ServiceCategoryList previousPage(String previousPage) {
    this.previousPage = previousPage;
    return this;
  }

  /**
   * The URL to access the previous page
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

  public ServiceCategoryList totalItemsCount(Integer totalItemsCount) {
    this.totalItemsCount = totalItemsCount;
    return this;
  }

  /**
   * The total number of items in the database
   * @return totalItemsCount
  */
  @NotNull 
  @Schema(name = "totalItemsCount", description = "The total number of items in the database", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalItemsCount")
  public Integer getTotalItemsCount() {
    return totalItemsCount;
  }

  public void setTotalItemsCount(Integer totalItemsCount) {
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
    ServiceCategoryList serviceCategoryList = (ServiceCategoryList) o;
    return Objects.equals(this.data, serviceCategoryList.data) &&
        Objects.equals(this.nextPage, serviceCategoryList.nextPage) &&
        Objects.equals(this.pageCount, serviceCategoryList.pageCount) &&
        Objects.equals(this.previousPage, serviceCategoryList.previousPage) &&
        Objects.equals(this.totalItemsCount, serviceCategoryList.totalItemsCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, nextPage, pageCount, previousPage, totalItemsCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategoryList {\n");
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

