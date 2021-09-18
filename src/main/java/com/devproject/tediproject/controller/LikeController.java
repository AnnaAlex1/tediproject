package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.LikeAddRequest;
import com.devproject.tediproject.repository.LikeRepository;
import com.devproject.tediproject.repository.PostRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LikeController {

    private final LikeRepository repository;
    @Autowired
    private ProfessionalRepository profRepository;
    @Autowired
    private PostRepository postRepository;

    LikeController(LikeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/post/like/add")
    Like newLike(@RequestBody LikeAddRequest newLikeRequest) {
        Optional<Professional> res = profRepository.findById(newLikeRequest.getProfessionalId());
        Professional professional = res.get();

        Optional<Post> res2 = postRepository.findById((newLikeRequest.getPostId()));
        Post post = res2.get();

        Like newLike = new Like(post, professional);
        post.addNewLike(newLike);

        repository.save(newLike);
        postRepository.save(post);
        return repository.save(newLike);

    }

    @GetMapping("post/{postId}/likes")
    List<Like> getLikeByPostId(@PathVariable Long postId) { return repository.findByPostIdPost(postId); }


//    @GetMapping("/post/{postId}/likes")
//    List<Like> get_All() { return repository.findAll(); }

    @DeleteMapping("/post/{postId}/{likeId}")
    void deleteLike(@PathVariable Long likeId) { repository.deleteById(likeId); }

}
