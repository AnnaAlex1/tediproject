package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Content {
    @Id private Long contentId;
    private ContentType type;
    private String path;

    @ManyToOne(cascade= CascadeType.ALL)
    private Comment comment;

    @ManyToOne(cascade= CascadeType.ALL)
    private JobPosting jobPosting;

    @ManyToOne(cascade= CascadeType.ALL)
    private Message message;

    @ManyToOne(cascade= CascadeType.ALL)
    private Post post;



}
