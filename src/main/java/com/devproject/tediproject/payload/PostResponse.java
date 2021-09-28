package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.Comment;
import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Professional;
import java.sql.Timestamp;
import java.util.List;


public class PostResponse {

    Long idPost;
    private Timestamp date_time;
    private Professional prof;
    private List<Content> content;
    private List<Like> likes;
    private List<Comment> comments;

    public PostResponse() { }

    public PostResponse(Long idPost, Timestamp date_time, Professional prof, List<Content> content, List<Like> likes, List<Comment> comments) {
        this.idPost = idPost;
        this.prof = prof;
//        this.prof.setPostList(null);
        this.date_time = date_time;
//        this.setProf(prof);
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

    public Professional getProf() {
        return prof;
    }

    public void setProf(Professional prof) {
        this.prof.setId(prof.getId());
        this.prof.setUsername(prof.getUsername());
        this.prof.setPassword(prof.getPassword());
        this.prof.setEmail(prof.getEmail());
        this.prof.setName(prof.getName());
        this.prof.setSurname(prof.getSurname());
        this.prof.setPhone(prof.getPhone());
        this.prof.setPicture_url(prof.getPicture_url());
        this.prof.setWork_place(prof.getWork_place());
        this.prof.setWork_position(prof.getWork_position());
        this.prof.setEmail_public(prof.getEmail_public());
        this.prof.setPhone_public(prof.getPhone_public());
        this.prof.setName_surname_public(prof.getName_surname_public());
        this.prof.setUserNotifications(prof.getUserNotifications());
        this.prof.setPostList(null);
        this.prof.setApplications(null);

    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
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
}