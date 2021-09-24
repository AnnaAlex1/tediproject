package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Content {
    @Id @GeneratedValue private Long contentId;

//    @Enumerated(EnumType.STRING)
    private ContentType type;
    private String path;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JsonBackReference(value="content-comment")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "jobPosting_id")
    @JsonBackReference(value="content-jobposting")
    private JobPosting jobPosting;

    @ManyToOne
    @JoinColumn(name = "message_id")
    @JsonBackReference(value="content-message")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference(value="content-post")
    private Post post;


    public Content() { }

    public Content(ContentType type, String path) {
        this.type = type;
        this.path = path;
    }

    public Content(ContentType type, String path, Post post) {
        this.type = type;
        this.path = path;
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
