package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.PictureNotFoundException;
import com.devproject.tediproject.model.Picture;
import com.devproject.tediproject.repository.PictureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PictureController {

    private final PictureRepository repository;

    PictureController(PictureRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/pics")
    Picture newPicture(@RequestBody Picture newPicture) { return repository.save(newPicture); }

    @GetMapping("/pics")
    List<Picture> get_All() { return repository.findAll(); }

    @GetMapping("/pics/{url}")
    Picture get_one(@PathVariable String url){
        return repository.findByUrl(url)
                .orElseThrow(() -> new PictureNotFoundException(url));
    }

    @PutMapping("/pics/{url}")
    Picture replacePicture(@RequestBody Picture newPicture, @PathVariable String url){

        return repository.findByUrl(url)
                .map(picture -> {
                    picture.setUrl(newPicture.getUrl());
                    return repository.save(picture);
                })
                .orElseGet(() -> {
                    newPicture.setUrl(url);
                    return repository.save(newPicture);
                });
    }

    @DeleteMapping("/pics/{url}")
    void deletePicture(@PathVariable String url) { repository.deleteByUrl(url); }
}
