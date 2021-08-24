package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, String> {

    Picture findByUrl(String url);
    void deleteByUrl(String url);
}
