package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Conversations {

    private @Id @GeneratedValue Long id;
    private Boolean wasRead;

    @OneToOne
    private Professional professional1;

    @OneToOne
    private Professional professional2;

//    @OneToOne
//    private Message last_message;

    @OneToMany
    @JsonManagedReference(value="conv-mes")
    private List<Message> messageList;


    public Conversations() { }


    public Conversations(Professional professional1, Professional professional2) {
        this.professional1 = professional1;
        this.professional2 = professional2;
//        this.last_message = null;
        this.messageList = null;
        this.wasRead = false;
    }

    public void setWasRead(Boolean wasRead) {
        this.wasRead = wasRead;
    }

    // Adds
    public void addInMessageList(Message message){
        this.messageList.add(message);
    }

}
