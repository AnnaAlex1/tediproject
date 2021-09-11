package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@IdClass(LikeId.class)
public class Like {

    @Id
    @OneToOne
    private Post post;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_liked;


    @ManyToOne(targetEntity = Professional.class)
    private Professional professional_posted;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_posted;

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


}
