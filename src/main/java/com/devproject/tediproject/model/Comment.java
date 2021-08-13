package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    private @Id @GeneratedValue Long idComment;
    private String text;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Post_idPost;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Post_Professional_idProfessional;


    public Comment(){}

    public Comment(Long idComment, String text, Professional professional_idProfessional, Professional post_idPost, Professional post_Professional_idProfessional) {
        this.idComment = idComment;
        this.text = text;
        Professional_idProfessional = professional_idProfessional;
        Post_idPost = post_idPost;
        Post_Professional_idProfessional = post_Professional_idProfessional;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }

    public Professional getPost_idPost() {
        return Post_idPost;
    }

    public void setPost_idPost(Professional post_idPost) {
        Post_idPost = post_idPost;
    }

    public Professional getPost_Professional_idProfessional() {
        return Post_Professional_idProfessional;
    }

    public void setPost_Professional_idProfessional(Professional post_Professional_idProfessional) {
        Post_Professional_idProfessional = post_Professional_idProfessional;
    }
}
