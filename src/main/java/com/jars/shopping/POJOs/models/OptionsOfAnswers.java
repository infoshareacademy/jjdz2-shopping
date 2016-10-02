package com.jars.shopping.POJOs.models;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "number",
        "label",
        "categories"
})
public class OptionsOfAnswers {

    @JsonProperty("number")
    private Integer number;
    @JsonProperty("label")
    private String label;
    @JsonProperty("categories")
    private OfferedCategories categories;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The number
     */
    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return The label
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return The categories
     */
    @JsonProperty("categories")
    public OfferedCategories getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    @JsonProperty("categories")
    public void setCategories(OfferedCategories categories) {
        this.categories = categories;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "OptionsOfAnswers{" +
                "number=" + number +
                ", label='" + label + '\'' +
                ", categories=" + categories +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}