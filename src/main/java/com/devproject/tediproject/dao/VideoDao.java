package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class VideoDao implements Dao<Video> {

    private List<Video> videos = new ArrayList<>();

    public VideoDao(List<Video> videos) {
        this.videos = videos;
    }

    public Optional<Video> get(String url){
        return Optional.ofNullable(videos.get(videos.indexOf(url)));
    }

    @Override
    public List<Video> getAll(){
        return videos;
    }

    @Override
    public void insert(Video video){
        videos.add(video);
    }

    @Override
    public void update(Video video, String[] params){
        video.setUrl(Objects.requireNonNull(
                params[0], "Url cannot be null"));

        videos.add(video);
    }

    @Override
    public void delete(Video video){
        videos.remove(video);
    }
}
