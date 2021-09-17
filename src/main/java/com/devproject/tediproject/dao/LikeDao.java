package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.model.Professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LikeDao implements Dao<Like> {

    private List<Like> likes = new ArrayList<>();

    public LikeDao(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public Optional<Like> get(long likeId){
        return Optional.ofNullable(likes.get((int)likeId));
    }

    @Override
    public List<Like> getAll(){
        return likes;
    }

    @Override
    public void insert(Like like){
        likes.add(like);
    }


    public void update(Like like, Long likeId, /*List<Professional> professionals*/ Professional professional, Post post){
        like.setLikeId(likeId);
//        like.setProfessionals_liked(professionals);
        like.setProfessional_liked(professional);
        like.setPost(post);

        likes.add(like);
    }

    @Override
    public void delete(Like like){
        likes.remove(like);
    }
}
