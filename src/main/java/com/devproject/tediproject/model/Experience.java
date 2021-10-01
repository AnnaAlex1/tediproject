package com.devproject.tediproject.model;

import com.devproject.tediproject.payload.ExperienceRequest;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

import static java.lang.Long.parseLong;
import static java.time.LocalDate.parse;


@Data
@Entity
//@IdClass(ExperienceId.class)
public class Experience {

    @EmbeddedId
    private ExperienceId expId;

//    @Id private String title;
    private LocalDate start_date;
    private LocalDate end_date;
//    @Id private String company_name;
//
//    @Id
//    @ManyToOne
//    private Professional professionalId;


    public Experience() { }

    public Experience(ExperienceRequest exp, Professional prof) {
        this.expId = new ExperienceId(exp.getTitle(),exp.getCompany_name(),prof);
        this.start_date = parse(exp.getStart_date());
        this.end_date = parse(exp.getEnd_date());

    }

    public ExperienceId getExpId() {
        return expId;
    }

    public void setExpId(ExperienceId expId) {
        this.expId = expId;
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


}
