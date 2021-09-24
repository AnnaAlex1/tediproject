package com.devproject.tediproject.repository;


import com.devproject.tediproject.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long>, ContentRepositoryCustom {
}
