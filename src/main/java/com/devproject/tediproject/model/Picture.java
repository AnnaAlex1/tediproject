package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Picture {

    @Id private String url;

    @ManyToMany(targetEntity = Message.class)
    private Set messageSet;

    public Picture() { }

    public Picture(String url, Set messageSet) {
        this.url = url;
        this.messageSet = messageSet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set messageSet) {
        this.messageSet = messageSet;
    }
}
