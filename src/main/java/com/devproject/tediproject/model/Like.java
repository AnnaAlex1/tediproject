package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name="likes")
public class Like {

    @Id private Long likeId;

    @ManyToOne
    @JsonBackReference(value="post-like")
    private Post post;

//    @OneToMany(targetEntity = Professional.class)
//    private List<Professional> professionals_liked;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional professional_liked;

    public Like(){}

//    public Like(Long likeId, Post post, List<Professional> professionals_liked) {
//        this.likeId = likeId;
//        this.post = post;
//        this.professionals_liked = professionals_liked;
//    }


    public Like(Long likeId, Post post, Professional professional_liked) {
        this.likeId = likeId;
        this.post = post;
        this.professional_liked = professional_liked;
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

    public Professional getProfessional_liked() {
        return professional_liked;
    }

    public void setProfessional_liked(Professional professional_liked) {
        this.professional_liked = professional_liked;
    }
//    public List<Professional> getProfessionals_liked() {
//        return professionals_liked;
//    }

//    public void setProfessionals_liked(List<Professional> professionals_liked) {
//        this.professionals_liked = professionals_liked;
//    }
}
