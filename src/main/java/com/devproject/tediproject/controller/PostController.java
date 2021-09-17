package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.PostNotFoundException;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository repository;

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/posts/add")
    Post newPost(@RequestBody Post newPost) { return repository.save(newPost); }

    @GetMapping("/posts")
    List<Post> get_All() { return repository.findAll(); }

    @GetMapping("/posts/{id}")
    Post get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @GetMapping("/posts/{profId}/feed")
    List<Post> getPostsInFeed(@PathVariable String profId){
        return repository.getPostsInFeed(Long.parseLong(profId));
    }

    @PutMapping("/posts/{id}")
    Post replaceUser(@RequestBody Post newPost, @PathVariable Long id){

        return repository.findById(id)
                .map(post -> {
                    post.setIdPost(newPost.getIdPost());
                    post.setContent(post.getContent());
                    post.setDate_time(newPost.getDate_time());
                    post.setProf(newPost.getProf());
                    return repository.save(post);
                })
                .orElseGet(() -> {
                    newPost.setIdPost(id);
                    return repository.save(newPost);
                });
    }

    @DeleteMapping("/post/{id}")
    void deletePost(@PathVariable Long id) { repository.deleteById(id); }

}
