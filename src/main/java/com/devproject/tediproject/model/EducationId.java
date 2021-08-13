package com.devproject.tediproject.model;

import java.io.Serializable;

public class EducationId implements Serializable {

    private String title;
    private String institution_name;

    public EducationId(String title, String institution_name) {
        this.title = title;
        this.institution_name = institution_name;
    }

}
