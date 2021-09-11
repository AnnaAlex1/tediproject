package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Notification {

    private @GeneratedValue @Id Long idNotification;
    private String text;

    @OneToOne
    private Professional prof;

    @OneToOne
    private Post post;

    @OneToOne
    private ConnectionRequest c_request;

    @OneToOne
    private Like like;

    public Notification() {}

    public Notification(Long idNotification, String text) {
        this.idNotification = idNotification;
        this.text = text;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Professional getProf() {
        return prof;
    }

    public void setProf(Professional prof) {
        this.prof = prof;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ConnectionRequest getC_request() {
        return c_request;
    }

    public void setC_request(ConnectionRequest c_request) {
        this.c_request = c_request;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }


}
