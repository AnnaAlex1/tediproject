package com.devproject.tediproject.model;


import java.io.Serializable;
import java.util.Objects;


public class ConnectionRequestId implements Serializable {
    private Long from;
    private Long to;

    public ConnectionRequestId(Long from, Long to) {
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
