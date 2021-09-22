package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.Content;

import java.util.List;

public class CommentAddRequest {

    Long professionalId;
    Long postId;
    List<ContentAddRequest> content;

    public Long getProfessionalId() { return professionalId; }

    public void setProfessionalId(Long professionalId) { this.professionalId = professionalId; }

    public Long getPostId() { return postId; }

    public void setPostId(Long postId) { this.postId = postId; }

    public List<ContentAddRequest> getContent() { return content; }

    public void setContent(List<ContentAddRequest> content) { this.content = content; }

}
