package com.jars.shopping.POJOs.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "title",
        "options"
})
public class Question {

    private Integer id;
    private String title;
    private List<OptionsOfAnswers> options = new ArrayList<OptionsOfAnswers>();



    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }


    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("options")
    public List<OptionsOfAnswers> getOptions() {
        return options;
    }


    @JsonProperty("options")
    public void setOptions(List<OptionsOfAnswers> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "\nid=" + id + "\nQuestion= " + title + "\nOptions" + options;

    }

}
