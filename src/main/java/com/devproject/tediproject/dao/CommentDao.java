package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Comment;
import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Post;
import com.devproject.tediproject.model.Professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CommentDao implements Dao<Comment> {

    private List<Comment> comments = new ArrayList<>();

    public CommentDao(List<Comment> comments){ this.comments = comments; }

    @Override
    public Optional<Comment> get(long id) { return Optional.ofNullable(comments.get((int)id)); }

    @Override
    public List<Comment> getAll() { return  comments; }

    @Override
    public void insert(Comment comment) { comments.add(comment); }


    public void update(Comment comment, Long commentId, Professional professional, Post post, List<Content> content){
        comment.setContent(content);
        comment.setIdComment(commentId);
        comment.setProfessional_idProfessional(professional);
        comment.setPost_idPost(post);
        comments.add(comment);
    }

    @Override
    public void delete(Comment comment){
        comments.remove(comment);
    }
}
