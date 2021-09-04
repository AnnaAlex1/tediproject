package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

import java.util.Set;

@Data
@Entity
public class Message {

    private @GeneratedValue @Id Long idMessage;

    //@ManyToOne(fetch = FetchType.LAZY)
    //private @Id Long idprofessional1;

    //@ManyToOne(fetch = FetchType.LAZY)
    //private @Id Long idprofessional2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Professional_idProfessional1")
    private Professional prof1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Professional_idProfessional2")
    private Professional prof2;

    private String text;
    private DateTimeFormatter date_time;

    @ManyToMany(targetEntity=Picture.class)
    private Set pictureSet;

    @ManyToMany(targetEntity=Video.class)
    private Set videoSet;

    public Message() { }

    public Message(Long idMessage, String text, DateTimeFormatter date_time, Set pics, Set videos) {
        this.idMessage = idMessage;
        this.text = text;
        this.date_time = date_time;
        this.pictureSet = pics;
        this.videoSet = videos;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
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

    public Professional getProf1() {
        return prof1;
    }

    public void setProf1(Professional prof1) {
        this.prof1 = prof1;
    }

    public Professional getProf2() {
        return prof2;
    }

    public void setProf2(Professional prof2) {
        this.prof2 = prof2;
    }

    public Set getPictureSet() {
        return pictureSet;
    }

    public void setPictureSet(Set pictureSet) {
        this.pictureSet = pictureSet;
    }

    public Set getVideoSet() {
        return videoSet;
    }

    public void setVideoSet(Set videoSet) {
        this.videoSet = videoSet;
    }

    /*
    public Message(Long idMessage, Long idprofessional1, Long idprofessional2, String text, DateTimeFormatter date_time) {
        this.idMessage = idMessage;
        //this.idprofessional1 = idprofessional1;
        //this.idprofessional2 = idprofessional2;
        this.prof1.setId(idprofessional1);
        this.prof2.setId(idprofessional2);
        this.text = text;
        this.date_time = date_time;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public Long getIdprofessional1() {
        return idprofessional1;
    }

    public void setIdprofessional1(Long idprofessional1) {
        this.idprofessional1 = idprofessional1;
    }

    public Long getIdprofessional2() {
        return idprofessional2;
    }

    public void setIdprofessional2(Long idprofessional2) {
        this.idprofessional2 = idprofessional2;
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
*/

}
