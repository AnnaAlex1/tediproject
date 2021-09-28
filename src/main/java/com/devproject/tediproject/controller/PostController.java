package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.*;
import com.devproject.tediproject.payload.PostAddRequest;
import com.devproject.tediproject.payload.PostResponse;
import com.devproject.tediproject.repository.ContentRepository;
import com.devproject.tediproject.repository.PostRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class PostController {

    private final PostRepository repository;

    @Autowired
    private ProfessionalRepository profRepository;
    @Autowired
    private ContentRepository contentRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

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
    PostResponse get_one(@PathVariable Long id){
        Optional<Post> res = repository.findById(id);
        Post oldPost = res.get();

        logger.info("Professional is: " + res.get().getProf().getUsername());

        PostResponse pres = new PostResponse();
        pres.setIdPost(oldPost.getIdPost());
        pres.setContent(oldPost.getContent());
        pres.setDate_time(oldPost.getDate_time());
        pres.setComments(oldPost.getComments());
        pres.setLikes(oldPost.getLikes());
        pres.setProf(oldPost.getProf());

        return pres;

    }

    @GetMapping("/posts/{profId}/feed")
    List<PostResponse> getPostsInFeed(@PathVariable String profId){
        List<Post> postList = repository.getPostsInFeed(Long.parseLong(profId));

        List<PostResponse> responseList = new ArrayList<PostResponse>();
        int i = 0;
        while (i < postList.size()) {

            responseList.add(new PostResponse(postList.get(i).getIdPost(),postList.get(i).getDate_time(),
                                            postList.get(i).getProf(),postList.get(i).getContent(),
                                            postList.get(i).getLikes(), postList.get(i).getComments()));
            i++;
        }

        return responseList;
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

    @DeleteMapping("/post/delete/{id}")
    void deletePost(@PathVariable Long id) {
        Optional<Post> res = repository.findById(id);
        Post post = res.get();

        Optional<Professional> res2 = profRepository.findById(post.getProf().getId());
        Professional prof = res2.get();
        prof.removePost(post);
        this.profRepository.save(prof);
        this.contentRepository.deleteByPostId(id);
        repository.deleteById(id);
    }

}
