package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.LikeNotFoundException;
import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.repository.LikeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {

    private final LikeRepository repository;

    LikeController(LikeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/likes")
    Like newLike(@RequestBody Like newLike) { return repository.save(newLike); }

    @GetMapping("/likes")
    List<Like> get_All() { return repository.findAll(); }

    @GetMapping("/likes/{post}")
    Like get_one(@PathVariable Post post){
        return repository.findByPost(post)
                .orElseThrow(() -> new LikeNotFoundException(post));
    }

    @PutMapping("/likes/{post}")
    Like replaceLike(@RequestBody Like newLike, @PathVariable Post post){

        return repository.findByPost(post)
                .map(like -> {
                    like.setPost(newLike.getPost());
                    like.setProfessional_posted(newLike.getProfessional_posted());
                    like.setProfessional_liked(newLike.getProfessional_liked());
                    return repository.save(like);
                })
                .orElseGet(() -> {
                    newLike.setPost(post);
                    return repository.save(newLike);
                });
    }

    @DeleteMapping("/likes/{post}")
    void deletePost(@PathVariable Post post) { repository.deleteByPost(post); }

}
