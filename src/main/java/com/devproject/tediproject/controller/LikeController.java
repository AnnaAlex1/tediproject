package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.repository.LikeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LikeController {

    private final LikeRepository repository;

    LikeController(LikeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/post/{postId}")
    Like newLike(@RequestBody Like newLike) { return repository.save(newLike); }

    @GetMapping("/post/{postId}/likes")
    List<Like> get_All() { return repository.findAll(); }

    @DeleteMapping("/post/{postId}/{likeId}")
    void deleteLike(@PathVariable Long likeId) { repository.deleteById(likeId); }

}
