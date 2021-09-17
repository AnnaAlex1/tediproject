package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>, PostRepositoryCustom {
}
