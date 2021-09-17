package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
public class Post {

    private @GeneratedValue @Id Long idPost;
    private Timestamp date_time;

    @ManyToOne
    @JoinColumn(name = "Professional_idProfessional")
    private Professional prof;


    @OneToMany(mappedBy="post", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-post")
    private List<Content> content;

    @OneToMany(cascade= CascadeType.ALL)
    @JsonManagedReference(value="post-like")
    private List<Like> likes;

    @OneToMany(cascade= CascadeType.ALL)
    @JsonManagedReference(value="comment-post")
    private List<Comment> comments;



    public Post() { }

    public Post(Long idPost, Professional prof, List<Content> content, List<Like> likes, List<Comment> comments) {
        this.idPost = idPost;
        this.date_time = new Timestamp(System.currentTimeMillis());
        this.prof = prof;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Professional getProf() {
        return prof;
    }

    public void setProf(Professional prof) {
        this.prof = prof;
    }
}
