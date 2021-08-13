package com.devproject.tediproject.model;

import java.io.Serializable;

public class ConnectionRequestId implements Serializable {
    private Long from;
    private Long to;

    public ConnectionRequestId(Long from, Long to) {
        this.from = from;
        this.to = to;
    }
}
