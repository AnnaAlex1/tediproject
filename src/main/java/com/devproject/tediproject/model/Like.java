package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name="likes")
public class Like {

    @Id private Long likeId;

    @OneToOne
    private Post post;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_liked;



    public Like(){}

    public Like(Long likeId, Post post, List<Professional> professionals_liked) {
        this.likeId = likeId;
        this.post = post;
        this.professionals_liked = professionals_liked;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Professional> getProfessionals_liked() {
        return professionals_liked;
    }

    public void setProfessionals_liked(List<Professional> professionals_liked) {
        this.professionals_liked = professionals_liked;
    }
}
