package com.devproject.tediproject.model;

import java.io.Serializable;


public class ExperienceId implements Serializable {
    private String title;
    private String company_name;

    public ExperienceId(String title, String company_name) {
        this.title = title;
        this.company_name = company_name;
    }
}
