package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Picture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public abstract class PictureDao implements Dao<Picture> {

    private List<Picture> pics = new ArrayList<>();

    public PictureDao(List<Picture> pics) {
        this.pics = pics;
    }

    public Optional<Picture> get(String url){
        return Optional.ofNullable(pics.get(pics.indexOf(url)));
    }

    @Override
    public List<Picture> getAll(){
        return pics;
    }

    @Override
    public void insert(Picture pic){
        pics.add(pic);
    }

    @Override
    public void update(Picture pic, String[] params){
        pic.setUrl(Objects.requireNonNull(
                params[0], "Url cannot be null"));

        pics.add(pic);
    }

    @Override
    public void delete(Picture pic){
        pics.remove(pic);
    }

}
