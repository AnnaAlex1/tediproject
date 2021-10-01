package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.CommentNotFoundException;
import com.devproject.tediproject.model.*;
import com.devproject.tediproject.payload.CommentAddRequest;
import com.devproject.tediproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    private final CommentRepository repository;

    @Autowired
    private ProfessionalRepository profRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/comments/add")
    Comment newComment(@RequestBody CommentAddRequest newCommentRequest) {

        //get professional
        Optional<Professional> res = profRepository.findById(newCommentRequest.getProfessionalId());
        Professional prof = res.get();

        //get post
        Optional<Post> res2 = postRepository.findById(newCommentRequest.getPostId());
        Post post = res2.get();

        //create comment (set professional, post)
        Comment newComment = new Comment(prof, post);

        //add instants of content to database
        List<Content> newContent = new ArrayList<Content>();;
        for (int i=0; i<newCommentRequest.getContent().size(); i++){
            newContent.add(new Content(newCommentRequest.getContent().get(i).getType(),
                    newCommentRequest.getContent().get(i).getPath(), newComment) );
        }

        //set list of contents in comment
        newComment.setContent(newContent);

        //add comment to post
        post.addNewComment(newComment);

        // Save in database
        repository.save(newComment);    //save new comment in database
        for (int i=0; i<newContent.size(); i++) {
            contentRepository.save(newContent.get(i));
        }
        postRepository.save(post);      //update post in database

        String message = "Professional " + prof.getUsername() + " commented on your post";
        Notification newNot = new Notification(message, newComment , post.getProf());
        notificationRepository.save(newNot);

        return repository.save(newComment);
    }

    @GetMapping("/comments")
    List<Comment> get_All() { return repository.findAll(); }



    @GetMapping("comments/{postId}")
    List<Comment> getCommentsOfPost(@PathVariable Long postId){
        return repository.findByPostId(postId);
    }


    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long id){

        return repository.findById(id)
                .map(comment -> {
                    comment.setContent(newComment.getContent());
                    return repository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setIdComment(id);
                    return repository.save(newComment);
                });
    }

    @DeleteMapping("/comments/delete/{id}")
    void deleteComment(@PathVariable Long id) { repository.deleteById(id); }
}
