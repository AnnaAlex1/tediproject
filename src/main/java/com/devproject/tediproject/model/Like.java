package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name="likes")
public class Like {

    @Id @GeneratedValue private Long likeId;

    @ManyToOne
    @JsonBackReference(value="post-like")
    private Post post;

    @OneToOne
    private Professional professional_liked;

//    @OneToOne(mappedBy = "likeNot")
//    private Notification notification;


    public Like(){}

    public Like(Post post, Professional professional_liked) {
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

}
