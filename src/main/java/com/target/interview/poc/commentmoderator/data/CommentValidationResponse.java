package com.target.interview.poc.commentmoderator.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "valid",
        "severe",
        "moderate"
})
public class CommentValidationResponse {

    @JsonProperty("valid")
    private boolean valid =false;

    @JsonProperty("severe")
    private List<String> severe;

    @JsonProperty("moderate")
    private List<String> moderate;

    @JsonProperty("valid")
    public boolean isValid() {
        return valid;
    }

    @JsonProperty("valid")
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @JsonProperty("severe")
    public List<String> getSevere() {
        return severe;
    }

    @JsonProperty("severe")
    public void setSevere(List<String> severe) {
        this.severe = severe;
    }

    @JsonProperty("moderate")
    public List<String> getModerate() {
        return moderate;
    }

    @JsonProperty("moderate")
    public void setModerate(List<String> moderate) {
        this.moderate = moderate;
    }

    @Override
    public String toString() {
        final StringBuilder sb =
                new StringBuilder("CommentValidationResponse{");
        sb.append("valid=").append(valid);
        sb.append(", severe=").append(severe);
        sb.append(", moderate=").append(moderate);
        sb.append('}');
        return sb.toString();
    }
}
