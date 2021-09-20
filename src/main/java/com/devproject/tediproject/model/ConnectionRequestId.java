package com.devproject.tediproject.model;


import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class ConnectionRequestId implements Serializable {
    @OneToOne(cascade= CascadeType.ALL)
    private Professional from;
    @OneToOne(cascade= CascadeType.ALL)
    private Professional to;

    public ConnectionRequestId() { }

    public ConnectionRequestId(Professional from, Professional to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConnectionRequestId)) return false;
        ConnectionRequestId that = (ConnectionRequestId) o;
        return from.equals(that.from) && to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
