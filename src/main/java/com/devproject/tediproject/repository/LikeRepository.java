package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    public List<Like> findByPostIdPost(Long postId);
}
