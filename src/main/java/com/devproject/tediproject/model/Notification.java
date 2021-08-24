package com.devproject.tediproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Notification {

    private @GeneratedValue @Id Long idNotification;
    private String text;

    @OneToOne
    private Professional prof;
    //private @Id Long Professional_idProfessional;

    @OneToOne
    private Post post;
    //private @Id Long Post_id_post;

    @OneToOne
    private Connection_request c_request;
    //private @Id Long Connection_request_from;
    //private @Id Long Connection_request_to;

    @OneToOne
    private Like like;
    //private @Id Long Like_professional_liked;
    //private @Id Long Like_professional_posted;

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

    public Connection_request getC_request() {
        return c_request;
    }

    public void setC_request(Connection_request c_request) {
        this.c_request = c_request;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }

    /*
    public Notification(Long idNotification, String text, Long professional_idProfessional, Long like_professional_liked, Long post_id_post, Long like_professional_posted, Long connection_request_from, Long connection_request_to) {
        this.idNotification = idNotification;
        this.text = text;
        Professional_idProfessional = professional_idProfessional;
        Like_professional_liked = like_professional_liked;
        Post_id_post = post_id_post;
        Like_professional_posted = like_professional_posted;
        Connection_request_from = connection_request_from;
        Connection_request_to = connection_request_to;
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

    public Long getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Long professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }

    public Long getLike_professional_liked() {
        return Like_professional_liked;
    }

    public void setLike_professional_liked(Long like_professional_liked) {
        Like_professional_liked = like_professional_liked;
    }

    public Long getPost_id_post() {
        return Post_id_post;
    }

    public void setPost_id_post(Long post_id_post) {
        Post_id_post = post_id_post;
    }

    public Long getLike_professional_posted() {
        return Like_professional_posted;
    }

    public void setLike_professional_posted(Long like_professional_posted) {
        Like_professional_posted = like_professional_posted;
    }

    public Long getConnection_request_from() {
        return Connection_request_from;
    }

    public void setConnection_request_from(Long connection_request_from) {
        Connection_request_from = connection_request_from;
    }

    public Long getConnection_request_to() {
        return Connection_request_to;
    }

    public void setConnection_request_to(Long connection_request_to) {
        Connection_request_to = connection_request_to;
    }

     */
}
