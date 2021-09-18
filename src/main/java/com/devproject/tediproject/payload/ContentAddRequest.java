package com.devproject.tediproject.payload;

import com.devproject.tediproject.model.ContentType;

public class ContentAddRequest {
    private ContentType type;
    private String path;

    public ContentType getType() { return type; }

    public void setType(ContentType type) { this.type = type; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

}
