package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Post> {

    Like findByPost(Post post);
    void deleteByPost(Post post);
}
