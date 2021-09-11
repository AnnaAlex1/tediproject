package com.devproject.tediproject.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

public class LikeId implements Serializable {
    @OneToOne
    private Post post;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professionals_liked;

    @OneToMany(targetEntity = Professional.class)
    private List<Professional> professional_posted;

    public LikeId(Post post, List<Professional> professionals_liked, List<Professional> professional_posted) {
        this.post = post;
        this.professionals_liked = professionals_liked;
        this.professional_posted = professional_posted;
    }
}