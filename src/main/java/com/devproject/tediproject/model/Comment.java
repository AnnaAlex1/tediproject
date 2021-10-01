package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Comment {

    private @Id @GeneratedValue Long idComment;

    @OneToOne
    @JoinColumn(name="professional_id_id")
    private Professional professionalId;

    @ManyToOne
    @JsonBackReference(value="comment-post")
    @JoinColumn(name="post_id_id_post")
    private Post postId;

    @OneToMany(mappedBy="comment", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-comment")
    private List<Content> content;

//    @OneToOne(mappedBy = "commentNot")
//    private Notification notification;


    public Comment(){}
    public Comment(Professional professionalId, Post postId) {
        this.professionalId = professionalId;
        this.postId = postId;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public Professional getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Professional professionalId) {
        this.professionalId = professionalId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
