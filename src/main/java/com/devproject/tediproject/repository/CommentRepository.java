package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
     public List<Comment> findByPostId(Long postId);
}
