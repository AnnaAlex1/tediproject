package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
public class Post {

    private @GeneratedValue @Id Long idPost;
    private String text;
    private Timestamp date_time;

    @ManyToOne
    @JoinColumn(name = "Professional_idProfessional")
    private Professional prof;

    @OneToMany
    private List<Like> likes;

    @OneToMany
    private List<Comment> comments;

    public Post() { }

    public Post(Long idPost, String text, Timestamp date_time, Professional prof, List<Like> likes, List<Comment> comments) {
        this.idPost = idPost;
        this.text = text;
        this.date_time = date_time;
        this.prof = prof;
        this.likes = likes;
        this.comments = comments;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

/*
    public Long getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Long professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }
    */

    public Professional getProf() {
        return prof;
    }

    public void setProf(Professional prof) {
        this.prof = prof;
    }
}
