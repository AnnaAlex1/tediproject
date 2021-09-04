package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
public class Like {

    @OneToOne
    @Id private Post post;
    //private @Id Long post_idPost;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_liked;
    //private @Id Long professional_liked;

    @ManyToOne(targetEntity = Professional.class)
    private Professional professional_posted;
    //private @Id Long professional_posted;

    public Like(){}

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

    public Professional getProfessional_posted() {
        return professional_posted;
    }

    public void setProfessional_posted(Professional professional_posted) {
        this.professional_posted = professional_posted;
    }

/*
    public Like(Long professional_liked, Long post_idPost, Long professional_posted) {
        this.professional_liked = professional_liked;
        this.post_idPost = post_idPost;
        this.professional_posted = professional_posted;
    }

    public Long getProfessional_liked() {
        return professional_liked;
    }

    public void setProfessional_liked(Long professional_liked) {
        this.professional_liked = professional_liked;
    }

    public Long getPost_idPost() {
        return post_idPost;
    }

    public void setPost_idPost(Long post_idPost) {
        this.post_idPost = post_idPost;
    }

    public Long getProfessional_posted() {
        return professional_posted;
    }

    public void setProfessional_posted(Long professional_posted) {
        this.professional_posted = professional_posted;
    }

 */
}
