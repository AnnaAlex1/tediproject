package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.VideoNotFoundException;
import com.devproject.tediproject.repository.VideoRepository;
import com.devproject.tediproject.model.Video;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VideoController {

    private final VideoRepository repository;

    VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/videos")
    Video newVideo(@RequestBody Video newVideo) { return repository.save(newVideo); }

    @GetMapping("/videos")
    List<Video> get_All() { return repository.findAll(); }

    @GetMapping("/videos/{url}")
    Video get_one(@PathVariable String url){
        return repository.findByUrl(url)
                .orElseThrow(() -> new VideoNotFoundException(url));
    }

    @PutMapping("/videos/{url}")
    Video replaceUser(@RequestBody Video newVideo, @PathVariable String url){

        return repository.findByUrl(url)
                .map(video -> {
                    video.setUrl(newVideo.getUrl());
                    return repository.save(video);
                })
                .orElseGet(() -> {
                    newVideo.setUrl(url);
                    return repository.save(newVideo);
                });
    }

    @DeleteMapping("/video/{url}")
    void deleteVideo(@PathVariable String url) { repository.deleteByUrl(url); }

}
