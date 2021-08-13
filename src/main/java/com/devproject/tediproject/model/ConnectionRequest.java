package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ConnectionRequestId.class)
public class ConnectionRequest {

    @OneToOne(cascade= CascadeType.ALL)
    @Id private Professional from;

    @OneToOne(cascade= CascadeType.ALL)
    @Id private Professional to;

    private boolean fromIsFollowingTo;

    private boolean toIsFollowingFrom;



    public ConnectionRequest() { }

    public ConnectionRequest(Professional from, Professional to, boolean fromIsFollowingTo, boolean toIsFollowingFrom) {
        this.from = from;
        this.to = to;
        this.fromIsFollowingTo = fromIsFollowingTo;
        this.toIsFollowingFrom = toIsFollowingFrom;
    }


    public Professional getFrom() {
        return from;
    }

    public void setFrom(Professional from) {
        this.from = from;
    }

    public Professional getTo() {
        return to;
    }

    public void setTo(Professional to) {
        this.to = to;
    }

    public boolean isFromIsFollowingTo() {
        return fromIsFollowingTo;
    }

    public void setFromIsFollowingTo(boolean fromIsFollowingTo) {
        this.fromIsFollowingTo = fromIsFollowingTo;
    }

    public boolean isToIsFollowingFrom() {
        return toIsFollowingFrom;
    }

    public void setToIsFollowingFrom(boolean toIsFollowingFrom) {
        this.toIsFollowingFrom = toIsFollowingFrom;
    }


}
