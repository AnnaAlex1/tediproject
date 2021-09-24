package com.devproject.tediproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class JobPosting {

    private @Id @GeneratedValue Long idJobPosting;

    private Timestamp date_time;

    @OneToOne
    @JoinColumn(name="prof_id")
    private Professional professional;

    @OneToMany(mappedBy="jobPosting", cascade = CascadeType.ALL)
    @JsonManagedReference(value="content-jobposting")
    private List<Content> content;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Professional> interested;



    public JobPosting() {  }

    public JobPosting(Professional professional, List<Content> content) {
        this.date_time = new Timestamp(System.currentTimeMillis());
        this.professional = professional;
        this.content = content;
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
