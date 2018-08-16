package com.target.interview.poc.commentmoderator.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "commentId",
        "comment",
})
public class Comment {

    @JsonProperty("commentId")
    private UUID commentId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("commentId")
    public UUID getCommentId() {
        return commentId;
    }

    @JsonProperty("commentId")
    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("commentId=").append(commentId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
