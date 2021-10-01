package com.devproject.tediproject.model;

import com.devproject.tediproject.payload.EducationRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.LocalDate.parse;

@Data
@Entity
//@IdClass(EducationId.class)
public class Education {

    @EmbeddedId
    private EducationId edId;
//    @Id private String title;

    private String type;
    private float grade;
    private LocalDate date;
//    @Id private String institution_name;

//    @Id
//    @ManyToOne
//    private Professional professionalId;


    public Education() { }

/*    public Education(String title, String type, float grade, LocalDate date, String institution_name, Professional professionalId) {
        this.title = title;
        this.type = type;
        this.grade = grade;
        this.date = date;
        this.institution_name = institution_name;
        this.professionalId = professionalId;
    }*/

    public Education(EducationRequest req, Professional prof) {
        this.edId = new EducationId(req.getTitle(),req.getInstitution_name(),prof);
//        this.edId.setTitle(req.getTitle());
        this.type = req.getType();
        this.grade = req.getGrade();
        this.date = parse(req.getDate());
//        this.edId.setInstitution_name(req.getInstitution_name());
//        this.edId.setProfessionalId(prof);

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

    public EducationId getEdId() {
        return edId;
    }

    public void setEdId(EducationId edId) {
        this.edId = edId;
    }
}
