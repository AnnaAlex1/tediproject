package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Post;

import java.util.List;

public interface PostRepositoryCustom {
    public List<Post> getPostsInFeed(Long profId);
}
