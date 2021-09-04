package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class ConnectionRequestId implements Serializable {
    private Long from;
    private Long to;

    public ConnectionRequestId(Long from, Long to) {
        this.from = from;
        this.to = to;
    }
}
