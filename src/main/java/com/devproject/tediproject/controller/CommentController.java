package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.CommentNotFoundException;
import com.devproject.tediproject.model.Comment;
import com.devproject.tediproject.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentRepository repository;

    CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment newComment) { return repository.save(newComment); }

    @GetMapping("/comments")
    List<Comment> get_All() { return repository.findAll(); }

    @GetMapping("comments/{id}")
    Comment get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));
    }

    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long id){

        return repository.findById(id)
                .map(comment -> {
                    comment.setText(newComment.getText());
                    return repository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setIdComment(id);
                    return repository.save(newComment);
                });
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id) { repository.deleteById(id); }
}
