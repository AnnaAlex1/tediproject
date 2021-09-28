package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Professional;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

public class JobPostingAddRequest {
    Long professional_id;
    List<ContentAddRequest> contentAdd;

    public Long getProfessional_id() {
        return professional_id;
    }

    public List<ContentAddRequest> getContentAdd() {
        return contentAdd;
    }

}
