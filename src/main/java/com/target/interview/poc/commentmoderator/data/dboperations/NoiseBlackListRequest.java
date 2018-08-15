package com.target.interview.poc.commentmoderator.data.dboperations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "noiseList"
        })
public class NoiseBlackListRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("noiseList")
    private List<String> noiseList;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("noiseList")
    public List<String> getNoiseList() {
        return noiseList;
    }

    @JsonProperty("noiseList")
    public void setNoiseList(List<String> noiseList) {
        this.noiseList = noiseList;
    }
}
