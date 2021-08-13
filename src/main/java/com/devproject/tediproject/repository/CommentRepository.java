package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{ }
