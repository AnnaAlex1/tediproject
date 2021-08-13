package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CommentDao implements Dao<Comment> {

    private List<Comment> comments = new ArrayList<>();

    public CommentDao(List<Comment> comments){ this.comments = comments; }

    @Override
    public Optional<Comment> get(long id) { return Optional.ofNullable(comments.get((int)id)); }

    @Override
    public List<Comment> getAll() { return  comments; }

    @Override
    public void insert(Comment comment) { comments.add(comment); }

    @Override
    public void update(Comment comment, String[] params){
        comment.setText(Objects.requireNonNull(
                params[0], "Text cannot be null" ));
        comment.setPost_idPost(Long.parseLong(params[1]));
        comment.setPost_Professional_idProfessional(Long.parseLong(params[2]));
        comment.setProfessional_idProfessional(Long.parseLong(params[3]));

        comments.add(comment);
    }

    @Override
    public void delete(Comment comment){
        comments.remove(comment);
    }
}
