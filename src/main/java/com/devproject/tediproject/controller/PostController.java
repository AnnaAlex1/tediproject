package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.PostNotFoundException;
import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.PostAddRequest;
import com.devproject.tediproject.repository.ContentRepository;
import com.devproject.tediproject.repository.PostRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class PostController {

    private final PostRepository repository;

    @Autowired
    private ProfessionalRepository profRepository;
    @Autowired
    private ContentRepository contentRepository;


    PostController(PostRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/posts/add")
    Post newPost(@RequestBody PostAddRequest newPostReq) {
       //get professional
        Optional<Professional> res = profRepository.findById(newPostReq.getProfId());
        Professional prof = res.get();

        //create new post //set professional
        Post newPost = new Post(prof);
        repository.save(newPost); //add post in database

        //create list of content
        List<Content> newContent = new ArrayList<Content>();;
        for (int i=0; i<newPostReq.getContent().size(); i++){
//            Content tempContent = new Content(newPostReq.getContent().get(i).getType(),
//                    newPostReq.getContent().get(i).getPath());
//            tempContent.setPost(newPost);
//            newContent.add(tempContent);
            newContent.add(new Content(newPostReq.getContent().get(i).getType(),
                    newPostReq.getContent().get(i).getPath(), newPost) );
        }

        // for new post
        newPost.setContent(newContent); //set content of new post
        repository.save(newPost); //add post in database

        //for professional
        prof.addNewPost(newPost); //add post to professional class
        profRepository.save(prof); //update professional

        //add content to array of contents
        for (int i=0; i<newContent.size(); i++) {
            contentRepository.save(newContent.get(i));
        }
        
        return newPost;
    }

    @GetMapping("/posts")
    List<Post> get_All() { return repository.findAll(); }  //TODO: doesn't return profId

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
