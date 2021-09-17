package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Comment {

    private @Id @GeneratedValue Long idComment;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="professional_id_id")
    private Professional professionalId;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference(value="comment-post")
    @JoinColumn(name="post_id_id_post")
    private Post postId;

//    @OneToOne(cascade= CascadeType.ALL)
//    private Professional postAuthorId;

    @OneToMany(mappedBy="comment", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-comment")
    private List<Content> content;


    public Comment(){}

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Comment(Long idComment, Professional professionalId, Post postId, List<Content> content) {
        this.idComment = idComment;
        this.professionalId = professionalId;
        this.postId = postId;
        this.content = content;
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


}
