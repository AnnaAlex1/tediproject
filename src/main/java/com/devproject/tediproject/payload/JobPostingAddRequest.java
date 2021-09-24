package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Professional;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

public class JobPostingAddRequest {
    Long Professional_id;
    List<ContentAddRequest> contentAdd;
}
