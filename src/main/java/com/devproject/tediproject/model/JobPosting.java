package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idJobPosting")
@Data
@Entity
//@JsonIgnoreProperties(value="applications")
public class JobPosting {

    private @Id @GeneratedValue Long idJobPosting;
    private Timestamp date_time;


    @OneToOne
    @JoinColumn(name="prof_id")
    private Professional professional;

    @OneToMany(mappedBy="jobPosting", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-jobposting")
    private List<Content> content;

    @ManyToMany
    private List<Professional> interested;



    public JobPosting() {  }

    public JobPosting(Professional professional) {
        this.date_time = new Timestamp(System.currentTimeMillis());
        this.professional = professional;
        this.content = null;
        this.interested = null;
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

    //ADDS
    public void addNewInterested( Professional professional ) { this.interested.add(professional); }


}
