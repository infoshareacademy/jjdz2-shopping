package com.jars.shopping.POJOs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "pl",
        "en"
})

public class OfferedCategories {

    @JsonProperty("pl")
    private List<String> pl = new ArrayList<String>();
    @JsonProperty("en")
    private List<String> en = new ArrayList<String>();
    @JsonIgnore


    @JsonProperty("pl")
    public List<String> getPl() {
        return pl;
    }

    @JsonProperty("pl")
    public void setPl(List<String> pl) {
        this.pl = pl;
    }

    @JsonProperty("en")
    public List<String> getEn() {
        return en;
    }

    @JsonProperty("en")
    public void setEn(List<String> en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "OfferedCategories{" +
                "pl=" + pl +
                ", en=" + en +
                '}';
    }
}