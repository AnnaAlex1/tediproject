package com.devproject.tediproject.model;

import javax.persistence.ManyToMany;
import java.util.Set;

public class Picture {

    private String url;

    @ManyToMany(targetEntity = Message.class)
    private Set messageSet;

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
