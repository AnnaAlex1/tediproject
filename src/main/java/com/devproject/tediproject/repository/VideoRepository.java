package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,String> {

    Video findByUrl(String url);
    void deleteByUrl(String url);

}
