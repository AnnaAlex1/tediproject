package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ContentNotFoundException;
import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.repository.ContentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/contents/add")
    Content newContent(@RequestBody Content newContent) { return repository.save(newContent); }

    @GetMapping("/contents")
    List<Content> get_All() { return repository.findAll(); }

    @GetMapping("contents/{id}")
    Content get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException(id));
    }

    @PutMapping("/contents/{id}")
    Content replaceContent(@RequestBody Content newContent, @PathVariable Long id){

        return repository.findById(id)
                .map(content -> {
                    content.setContentId(newContent.getContentId());
                    content.setType(newContent.getType());
                    content.setPath(newContent.getPath());
                    return repository.save(content);
                })
                .orElseGet(() -> {
                    newContent.setContentId(id);
                    return repository.save(newContent);
                });
    }

    @DeleteMapping("/contents/delete/{id}")
    void deleteContent(@PathVariable Long id) { repository.deleteById(id); }
}
