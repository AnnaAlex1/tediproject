package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Notification {

    private @GeneratedValue @Id Long idNotification;
    private String text;
    private Boolean wasRead;
    private Timestamp dateTime;


    @ManyToOne
    @JsonBackReference(value="prof-not")
    private Professional profId;


    @OneToOne
    private Comment commentNot;

    @OneToOne
    private ConnectionRequest cRequestNot;

    @OneToOne
    private Like likeNot;



//    Constructors
    public Notification() {}

//
//    public Notification(String text, Timestamp date_time, Professional professional) {
//        this.text = text;
//        this.was_read = false;
//        this.date_time1 = date_time;
//        this.prof = professional;
//        this.commentNot = null;
//        this.c_requestNot = null;
//        this.likeNot = null;
//    }
//
//    public Notification(String text,  Timestamp date_time, Comment comment){
//        this.text = text;
//        this.was_read = false;
//        this.date_time1 = date_time;
//        this.prof = null;
//        this.commentNot = comment;
//        this.c_requestNot = null;
//        this.likeNot = null;
//    }
//
//    public Notification(String text,  Timestamp date_time, ConnectionRequest connectionRequest){
//        this.text = text;
//        this.was_read = false;
//        this.date_time1 = date_time;
//        this.prof = null;
//        this.commentNot = null;
//        this.c_requestNot = connectionRequest;
//        this.likeNot = null;
//    }
//
//    public Notification(String text,  Timestamp date_time, Like like) {
//        this.text = text;
//        this.was_read = false;
//        this.date_time1 = date_time;
//        this.prof = null;
//        this.commentNot = null;
//        this.c_requestNot = null;
//        this.likeNot = like;
//    }
//

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

    public Boolean getWasRead() {
        return wasRead;
    }

    public void setWasRead(Boolean wasRead) {
        this.wasRead = wasRead;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public ConnectionRequest getcRequestNot() {
        return cRequestNot;
    }

    public void setcRequestNot(ConnectionRequest cRequestNot) {
        this.cRequestNot = cRequestNot;
    }

    public Professional getProfId() {
        return profId;
    }

    public void setProfId(Professional profId) {
        this.profId = profId;
    }

    public Comment getCommentNot() {
        return commentNot;
    }

    public void setCommentNot(Comment commentNot) {
        this.commentNot = commentNot;
    }


    public Like getLikeNot() {
        return likeNot;
    }

    public void setLikeNot(Like likeNot) {
        this.likeNot = likeNot;
    }
}
