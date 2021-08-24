package com.devproject.tediproject.exception;

import com.devproject.tediproject.model.Post;

public class LikeNotFoundException extends RuntimeException {
    public LikeNotFoundException(Post post) {
        super("Could not find like about post " + post.getIdPost());
    }
}
