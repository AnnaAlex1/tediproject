package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class JobPosting {

    private @Id @GeneratedValue Long idJob_posting;
    private String text;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;

    @ManyToMany
    private Collection<Picture> pictures;

    @ManyToMany
    private Collection<Video> videos;

    public JobPosting() {  }

    public JobPosting(Long idJob_posting, String text, Professional professional_idProfessional) {
        this.idJob_posting = idJob_posting;
        this.text = text;
        Professional_idProfessional = professional_idProfessional;
    }

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


}
