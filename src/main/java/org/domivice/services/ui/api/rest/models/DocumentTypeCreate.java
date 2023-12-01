package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The document type object
 */

@Schema(name = "DocumentTypeCreate", description = "The document type object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class DocumentTypeCreate {

    private String name;

    private String issuingCountryCode;

    private String issuingStateCode;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentTypeCreate#DocumentTypeCreate(String, String, String)}
     */
    @Deprecated
    public DocumentTypeCreate() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentTypeCreate(String name, String issuingCountryCode, String issuingStateCode) {
        this.name = name;
        this.issuingCountryCode = issuingCountryCode;
        this.issuingStateCode = issuingStateCode;
    }

    public DocumentTypeCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The document type name e.g. Canadian Birth Certificate, Canadian Passport
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", description = "The document type name e.g. Canadian Birth Certificate, Canadian Passport", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentTypeCreate issuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
        return this;
    }

    /**
     * The issuing country code
     *
     * @return issuingCountryCode
     */
    @NotNull
    @Schema(name = "issuingCountryCode", description = "The issuing country code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingCountryCode")
    public String getIssuingCountryCode() {
        return issuingCountryCode;
    }

    public void setIssuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
    }

    public DocumentTypeCreate issuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
        return this;
    }

    /**
     * The issuing state code
     *
     * @return issuingStateCode
     */
    @NotNull
    @Schema(name = "issuingStateCode", description = "The issuing state code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingStateCode")
    public String getIssuingStateCode() {
        return issuingStateCode;
    }

    public void setIssuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentTypeCreate documentTypeCreate = (DocumentTypeCreate) o;
        return Objects.equals(this.name, documentTypeCreate.name) &&
                Objects.equals(this.issuingCountryCode, documentTypeCreate.issuingCountryCode) &&
                Objects.equals(this.issuingStateCode, documentTypeCreate.issuingStateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, issuingCountryCode, issuingStateCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentTypeCreate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    issuingCountryCode: ").append(toIndentedString(issuingCountryCode)).append("\n");
        sb.append("    issuingStateCode: ").append(toIndentedString(issuingStateCode)).append("\n");
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

