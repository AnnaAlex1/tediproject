package com.devproject.tediproject.payload;

public class LikeAddRequest {
    Long postId;
    Long professionalId;


    public Long getPostId() { return postId; }

    public void setPostId(Long postId) { this.postId = postId; }

    public Long getProfessionalId() { return professionalId; }

    public void setProfessionalId(Long professionalId) { this.professionalId = professionalId; }
}
