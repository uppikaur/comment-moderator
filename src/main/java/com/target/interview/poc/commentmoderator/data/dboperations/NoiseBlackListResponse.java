package com.target.interview.poc.commentmoderator.data.dboperations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "noiseId",
        "type",
        "noise"
})
public class NoiseBlackListResponse {

    @JsonProperty("noisetId")
    private UUID noiseId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("noise")
    private String noise;

    @JsonProperty("error")
    private String error;

    @JsonProperty("noisetId")
    public UUID getNoiseId() {
        return noiseId;
    }
    
    @JsonProperty("noisetId")
    public void setNoiseId(UUID noiseId) {
        this.noiseId = noiseId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("noise")
    public String getNoise() {
        return noise;
    }

    @JsonProperty("noise")
    public void setNoise(String noise) {
        this.noise = noise;
    }

    @JsonProperty("error")
    public String getError(String error) {
        return this.error;
    }

    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }
}
