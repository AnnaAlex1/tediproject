package com.devproject.tediproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@IdClass(ExperienceId.class)
public class Experience {

    @Id private String title;
    private Date start_date;
    private Date end_date;
    @Id private String company_name;

    @ManyToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;


    public Experience() { }

    public Experience(String title, Date start_date, Date end_date, String company_name, Professional professional_idProfessional) {
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.company_name = company_name;
        Professional_idProfessional = professional_idProfessional;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }
}
