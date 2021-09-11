package com.devproject.tediproject.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@IdClass(EducationId.class)
public class Education {

    @Id private String title;
    private String type;
    private float grade;
    private LocalDate date;
    @Id private String institution_name;

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    private Professional professionalId;


    public Education() { }

    public Education(String title, String type, float grade, LocalDate date, String institution_name, Professional professionalId) {
        this.title = title;
        this.type = type;
        this.grade = grade;
        this.date = date;
        this.institution_name = institution_name;
        this.professionalId = professionalId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public Professional getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Professional professionalId) {
        this.professionalId = professionalId;
    }
}
