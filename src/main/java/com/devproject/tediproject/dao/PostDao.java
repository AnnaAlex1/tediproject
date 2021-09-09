package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Post;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Objects.requireNonNull;

public class PostDao implements Dao<Post>{

    private List<Post> posts = new ArrayList<>();

    public PostDao(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Optional<Post> get(long id){
        return Optional.ofNullable(posts.get((int)id));
    }

    @Override
    public List<Post> getAll(){
        return posts;
    }

    @Override
    public void insert(Post post){
        posts.add(post);
    }

    @Override
    public void update(Post post, String[] params){
        post.setIdPost(requireNonNull(Long.parseLong(params[0]),"IdPost cannot be null"));
        post.setText(Objects.requireNonNull(params[1], "Password cannot be null"));
        post.setDate_time(Timestamp.valueOf(params[2]));
        //post.setProf(params[3]);

        posts.add(post);
    }

    @Override
    public void delete(Post post){
        posts.remove(post);
    }
}
