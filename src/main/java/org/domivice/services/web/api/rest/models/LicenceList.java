package org.domivice.services.web.api.rest.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.domivice.services.web.api.rest.models.Licence;
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

@Schema(name = "LicenceList", description = "")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-05T11:01:27.383569-05:00[America/Toronto]")
public class LicenceList {

  @Valid
  private List<@Valid Licence> data = new ArrayList<>();

  private String nextPage;

  private BigDecimal pageCount;

  private String previousPage;

  private BigDecimal totalItemsCount;

  /**
   * Default constructor
   * @deprecated Use {@link LicenceList#LicenceList(List<@Valid Licence>, String, BigDecimal, String, BigDecimal)}
   */
  @Deprecated
  public LicenceList() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LicenceList(List<@Valid Licence> data, String nextPage, BigDecimal pageCount, String previousPage, BigDecimal totalItemsCount) {
    this.data = data;
    this.nextPage = nextPage;
    this.pageCount = pageCount;
    this.previousPage = previousPage;
    this.totalItemsCount = totalItemsCount;
  }

  public LicenceList data(List<@Valid Licence> data) {
    this.data = data;
    return this;
  }

  public LicenceList addDataItem(Licence dataItem) {
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
  public List<@Valid Licence> getData() {
    return data;
  }

  public void setData(List<@Valid Licence> data) {
    this.data = data;
  }

  public LicenceList nextPage(String nextPage) {
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

  public LicenceList pageCount(BigDecimal pageCount) {
    this.pageCount = pageCount;
    return this;
  }

  /**
   * The page count
   * @return pageCount
  */
  @NotNull @Valid 
  @Schema(name = "pageCount", description = "The page count", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pageCount")
  public BigDecimal getPageCount() {
    return pageCount;
  }

  public void setPageCount(BigDecimal pageCount) {
    this.pageCount = pageCount;
  }

  public LicenceList previousPage(String previousPage) {
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

  public LicenceList totalItemsCount(BigDecimal totalItemsCount) {
    this.totalItemsCount = totalItemsCount;
    return this;
  }

  /**
   * The total number of items in the database
   * @return totalItemsCount
  */
  @NotNull @Valid 
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
    LicenceList licenceList = (LicenceList) o;
    return Objects.equals(this.data, licenceList.data) &&
        Objects.equals(this.nextPage, licenceList.nextPage) &&
        Objects.equals(this.pageCount, licenceList.pageCount) &&
        Objects.equals(this.previousPage, licenceList.previousPage) &&
        Objects.equals(this.totalItemsCount, licenceList.totalItemsCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, nextPage, pageCount, previousPage, totalItemsCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicenceList {\n");
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

