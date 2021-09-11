package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@IdClass(ExperienceId.class)
public class Experience {

    @Id private String title;
    private LocalDate start_date;
    private LocalDate end_date;
    @Id private String company_name;

    @Id
    @ManyToOne(cascade= CascadeType.ALL)
    private Professional professionalId;


    public Experience() { }

    public Experience(String title, LocalDate start_date, LocalDate end_date, String company_name, Professional professionalId) {
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.company_name = company_name;
        this.professionalId = professionalId;
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
