package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JobPosting {

    private @Id @GeneratedValue Long idJob_posting;
    private String text;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;

    @OneToMany
    private List<String> pictures;
    @OneToMany
    private List<String> videos;

    public Long getIdJob_posting() {
        return idJob_posting;
    }

    public void setIdJob_posting(Long idJob_posting) {
        this.idJob_posting = idJob_posting;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public JobPosting() {  }

    public JobPosting(Long idJob_posting, String text, Professional professional_idProfessional, List<String> pictures, List<String> videos) {
        this.idJob_posting = idJob_posting;
        this.text = text;
        Professional_idProfessional = professional_idProfessional;
        this.pictures = pictures;
        this.videos = videos;
    }
}
