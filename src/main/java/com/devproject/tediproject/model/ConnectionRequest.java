package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ConnectionRequest {
//
//    @OneToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name = "from_id")
//    @Id private Professional from;
//
//    @OneToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name = "to_id")
//    @Id private Professional to;

    @EmbeddedId
    private ConnectionRequestId idFromTo;

    private boolean fromIsFollowingTo;

    private boolean toIsFollowingFrom;



    public ConnectionRequest() { }

    public ConnectionRequestId getIdFromTo() {
        return idFromTo;
    }

    public void setIdFromTo(ConnectionRequestId idFromTo) {
        this.idFromTo = idFromTo;
    }

    public ConnectionRequest(ConnectionRequestId idFromTo) {
        this.idFromTo = idFromTo;
        this.fromIsFollowingTo = false;
        this.toIsFollowingFrom = false;
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
