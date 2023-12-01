package org.domivice.services.ui.api.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * The document type object
 */

@Schema(name = "DocumentTypePatch", description = "The document type object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class DocumentTypePatch {

    private UUID id;

    private String name;

    private String issuingCountryCode;

    private String issuingStateCode;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentTypePatch#DocumentTypePatch(UUID)}
     */
    @Deprecated
    public DocumentTypePatch() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentTypePatch(UUID id) {
        this.id = id;
    }

    public DocumentTypePatch id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * The document type id
     *
     * @return id
     */
    @NotNull
    @Valid
    @Schema(name = "id", description = "The document type id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentTypePatch name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The document type name e.g. Canadian Birth Certificate, Canadian Passport
     *
     * @return name
     */

    @Schema(name = "name", description = "The document type name e.g. Canadian Birth Certificate, Canadian Passport", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentTypePatch issuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
        return this;
    }

    /**
     * The issuing country code
     *
     * @return issuingCountryCode
     */

    @Schema(name = "issuingCountryCode", description = "The issuing country code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("issuingCountryCode")
    public String getIssuingCountryCode() {
        return issuingCountryCode;
    }

    public void setIssuingCountryCode(String issuingCountryCode) {
        this.issuingCountryCode = issuingCountryCode;
    }

    public DocumentTypePatch issuingStateCode(String issuingStateCode) {
        this.issuingStateCode = issuingStateCode;
        return this;
    }

    /**
     * The issuing state code
     *
     * @return issuingStateCode
     */

    @Schema(name = "issuingStateCode", description = "The issuing state code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
        DocumentTypePatch documentTypePatch = (DocumentTypePatch) o;
        return Objects.equals(this.id, documentTypePatch.id) &&
                Objects.equals(this.name, documentTypePatch.name) &&
                Objects.equals(this.issuingCountryCode, documentTypePatch.issuingCountryCode) &&
                Objects.equals(this.issuingStateCode, documentTypePatch.issuingStateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, issuingCountryCode, issuingStateCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentTypePatch {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

