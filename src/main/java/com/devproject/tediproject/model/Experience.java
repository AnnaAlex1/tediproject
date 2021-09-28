package com.devproject.tediproject.model;

import com.devproject.tediproject.payload.ExperienceRequest;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

import static java.lang.Long.parseLong;
import static java.time.LocalDate.parse;


@Data
@Entity
@IdClass(ExperienceId.class)
public class Experience {

    @Id private String title;
    private LocalDate start_date;
    private LocalDate end_date;
    @Id private String company_name;

    @Id
    @ManyToOne
    private Professional professionalId;


    public Experience() { }

    public Experience(ExperienceRequest exp) {
        this.title = exp.getTitle();
        this.start_date = parse(exp.getStart_date());
        this.end_date = parse(exp.getEnd_date());
        this.company_name = exp.getCompany_name();
        this.professionalId.setId(exp.getProfessional_id());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Professional getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Professional professionalId) {
        this.professionalId = professionalId;
    }
}
