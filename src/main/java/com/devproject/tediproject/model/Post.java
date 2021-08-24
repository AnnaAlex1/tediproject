package com.devproject.tediproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.format.DateTimeFormatter;

public class Post {

    private @GeneratedValue @Id Long idPost;
    private String text;
    private DateTimeFormatter date_time;

    //private @Id Long Professional_idProfessional;

    @ManyToOne
    @JoinColumn(name = "Professional_idProfessional")
    private Professional prof;

    /*
    public Post(Long idPost, String text, DateTimeFormatter date_time, Long professional_idProfessional) {
        this.idPost = idPost;
        this.text = text;
        this.date_time = date_time;
        Professional_idProfessional = professional_idProfessional;
    }
    */

    public Post(Long idPost, String text, DateTimeFormatter date_time) {
        this.idPost = idPost;
        this.text = text;
        this.date_time = date_time;
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

    public DateTimeFormatter getDate_time() {
        return date_time;
    }

    public void setDate_time(DateTimeFormatter date_time) {
        this.date_time = date_time;
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
