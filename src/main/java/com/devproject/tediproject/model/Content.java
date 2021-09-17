package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Content {
    @Id @GeneratedValue private Long contentId;
    private ContentType type;
    private String path;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    @JsonBackReference(value="content-comment")
    private Comment comment;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "jobPosting_id")
    @JsonBackReference(value="content-jobposting")
    private JobPosting jobPosting;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "message_id")
    @JsonBackReference(value="content-message")
    private Message message;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @JsonBackReference(value="content-post")
    private Post post;



}
