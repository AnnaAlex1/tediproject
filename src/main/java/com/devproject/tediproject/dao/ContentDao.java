package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.devproject.tediproject.model.ContentType;

public abstract class ContentDao implements Dao<Content> {
    private List<Content> contents = new ArrayList<>();

    public ContentDao(List<Content> content) {
        this.contents = content;
    }

    @Override
    public Optional<Content> get(long id){
        return Optional.ofNullable(contents.get((int)id));
    }

    @Override
    public List<Content> getAll(){
        return contents;
    }

    @Override
    public void insert(Content content){
        contents.add(content);
    }


    public void update(Content content, Long id, ContentType type, String path){
        content.setContentId(id);
        content.setType(type);
        content.setPath(path);
        contents.add(content);
    }


    @Override
    public void delete(Content content){
        contents.remove(content);
    }

}
