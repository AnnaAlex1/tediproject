package com.devproject.tediproject.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;
public class Like {

    @OneToOne
    private Post post;
    //private @Id Long post_idPost;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_liked;
    //private @Id Long professional_liked;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professional_posted;
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

    public List<Professional> getProfessional_posted() {
        return professional_posted;
    }

    public void setProfessional_posted(List<Professional> professional_posted) {
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
