package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.Content;

import java.util.List;

public class PostAddRequest {

    Long profId;
    List<ContentAddRequest> content;

    public Long getProfId() { return profId; }

    public void setProfId(Long id) { this.profId = id; }

    public List<ContentAddRequest> getContent() { return content; }

    public void setContent(List<ContentAddRequest> content) { this.content = content; }
}
