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

@Schema(name = "DocumentType", description = "The document type object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-01T10:55:04.412274-05:00[America/Toronto]")
public class DocumentType {

    private UUID id;

    private String name;

    private Country issuingCountry;

    private State issuingState;

    /**
     * Default constructor
     *
     * @deprecated Use {@link DocumentType#DocumentType(UUID, String, Country, State)}
     */
    @Deprecated
    public DocumentType() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public DocumentType(UUID id, String name, Country issuingCountry, State issuingState) {
        this.id = id;
        this.name = name;
        this.issuingCountry = issuingCountry;
        this.issuingState = issuingState;
    }

    public DocumentType id(UUID id) {
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

    public DocumentType name(String name) {
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

    public DocumentType issuingCountry(Country issuingCountry) {
        this.issuingCountry = issuingCountry;
        return this;
    }

    /**
     * Get issuingCountry
     *
     * @return issuingCountry
     */
    @NotNull
    @Valid
    @Schema(name = "issuingCountry", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingCountry")
    public Country getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(Country issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public DocumentType issuingState(State issuingState) {
        this.issuingState = issuingState;
        return this;
    }

    /**
     * Get issuingState
     *
     * @return issuingState
     */
    @NotNull
    @Valid
    @Schema(name = "issuingState", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("issuingState")
    public State getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(State issuingState) {
        this.issuingState = issuingState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentType documentType = (DocumentType) o;
        return Objects.equals(this.id, documentType.id) &&
                Objects.equals(this.name, documentType.name) &&
                Objects.equals(this.issuingCountry, documentType.issuingCountry) &&
                Objects.equals(this.issuingState, documentType.issuingState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, issuingCountry, issuingState);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentType {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    issuingCountry: ").append(toIndentedString(issuingCountry)).append("\n");
        sb.append("    issuingState: ").append(toIndentedString(issuingState)).append("\n");
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

