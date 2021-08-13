package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@IdClass(EducationId.class)
public class Education {


    @Id private String title;
    private String type;
    private float grade;
    private Date date;
    @Id private String institution_name;


    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;


    public Education() { }

    public Education(String title, String type, float grade, Date date, String institution_name, Professional professional_idProfessional) {
        this.title = title;
        this.type = type;
        this.grade = grade;
        this.date = date;
        this.institution_name = institution_name;
        Professional_idProfessional = professional_idProfessional;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }
}
