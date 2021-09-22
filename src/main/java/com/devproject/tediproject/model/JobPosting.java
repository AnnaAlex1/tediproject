package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JobPosting {

    private @Id @GeneratedValue Long idJobPosting;

    @OneToOne(cascade= CascadeType.ALL)
    private Professional Professional_idProfessional;

    @OneToMany(mappedBy="jobPosting", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-jobposting")
    private List<Content> content;

    @ManyToMany(mappedBy="applications", cascade = CascadeType.ALL)
//    @JsonManagedReference(value="prof-jobposting")
    private List<Professional> interested;



    public JobPosting() {  }

    public JobPosting(Long idJobPosting, Professional professional_idProfessional, List<Content> content) {
        this.idJobPosting = idJobPosting;
        Professional_idProfessional = professional_idProfessional;
        this.content = content;
    }



    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Long getIdJobPosting() {
        return idJobPosting;
    }

    public void setIdJobPosting(Long idJobPosting) {
        this.idJobPosting = idJobPosting;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    public void setProfessional_idProfessional(Professional professional_idProfessional) {
        Professional_idProfessional = professional_idProfessional;
    }


}
