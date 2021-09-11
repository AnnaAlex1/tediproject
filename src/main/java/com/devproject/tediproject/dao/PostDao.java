package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.*;
import java.sql.Timestamp;
import java.util.*;

public abstract class PostDao implements Dao<Post>{

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


    public void update(Post post, Long id, List<Content> content, Timestamp date, List<Comment> comments, List<Like> likes, Professional prof){
        post.setIdPost(id);
        post.setContent(content);
        post.setDate_time(date);
        post.setComments(comments);
        post.setLikes(likes);
        post.setProf(prof);

        posts.add(post);
    }

    @Override
    public void delete(Post post){
        posts.remove(post);
    }
}
