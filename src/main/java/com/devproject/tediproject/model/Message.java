package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.sql.Timestamp;

@Data
@Entity
public class Message {

    private @GeneratedValue @Id Long idMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="conversation_id")
    @JsonBackReference(value="conv-mes")
    private Conversations conversation;

    private Timestamp date_time;

    @OneToMany(mappedBy="message", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-message")
    private List<Content> content;

    public Message() { }


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="Professional_idProfessional1")
//    private Professional prof1;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="Professional_idProfessional2")
//    @JsonBackReference(value="prof-mes")
//    private Professional prof2;
//    public Message(Long idMessage, Professional prof1, Professional prof2, Timestamp date_time, List<Content> content) {
//        this.idMessage = idMessage;
////        this.prof1 = prof1;
////        this.prof2 = prof2;
//        this.date_time = date_time;
//        this.content = content;
//    }


    public Message(Conversations conversation) {
        this.conversation = conversation;
        this.date_time =  new Timestamp(System.currentTimeMillis());
        this.content = null;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

//    public Professional getProf1() {
//        return prof1;
//    }
//
//    public void setProf1(Professional prof1) {
//        this.prof1 = prof1;
//    }
//
//    public Professional getProf2() {
//        return prof2;
//    }
//
//    public void setProf2(Professional prof2) {
//        this.prof2 = prof2;
//    }


    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
