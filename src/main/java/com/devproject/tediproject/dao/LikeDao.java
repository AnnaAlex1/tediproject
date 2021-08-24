package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Like;
import com.devproject.tediproject.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LikeDao implements Dao<Like> {

    private List<Like> likes = new ArrayList<>();

    public LikeDao(List<Like> likes) {
        this.likes = likes;
    }

    public Optional<Like> get(Post post){
        return Optional.ofNullable(likes.get(likes.indexOf(post)));
    }

    @Override
    public List<Like> getAll(){
        return likes;
    }

    @Override
    public void insert(Like like){
        likes.add(like);
    }

    /*
    @Override
    public void update(Like like, String[] params){
        like.setUsername(Objects.requireNonNull(
                params[0], "Username cannot be null"));
        like.setPassword(Objects.requireNonNull(params[1], "Password cannot be null"));

        likes.add(like);
    }

     */

    @Override
    public void delete(Like like){
        likes.remove(like);
    }
}
