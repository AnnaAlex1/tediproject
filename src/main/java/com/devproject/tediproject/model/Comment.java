package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Comment {

    private @Id @GeneratedValue Long idComment;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;

    @ManyToOne(cascade= CascadeType.ALL)
    private Post Post_idPost;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Post_Professional_idProfessional;

    @OneToMany
    private List<Content> content;


    public Comment(){}

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Comment(Long idComment, Professional professional_idProfessional, Post post_idPost, Professional post_Professional_idProfessional, List<Content> content) {
        this.idComment = idComment;
        Professional_idProfessional = professional_idProfessional;
        Post_idPost = post_idPost;
        Post_Professional_idProfessional = post_Professional_idProfessional;
        this.content = content;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }


    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }

    public Post getPost_idPost() {
        return Post_idPost;
    }

    public void setPost_idPost(Post post_idPost) {
        Post_idPost = post_idPost;
    }

    public Professional getPost_Professional_idProfessional() {
        return Post_Professional_idProfessional;
    }

    public void setPost_Professional_idProfessional(Professional post_Professional_idProfessional) {
        Post_Professional_idProfessional = post_Professional_idProfessional;
    }
}
