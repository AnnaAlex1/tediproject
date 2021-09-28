package com.devproject.tediproject.storage;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Image {

    @Id @GeneratedValue
    private Long id;

    private String path;

    public Image() { }

    public Image(String path) {
        this.path = path;
    }
}
