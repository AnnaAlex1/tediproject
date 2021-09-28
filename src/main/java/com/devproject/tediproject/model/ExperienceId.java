package com.devproject.tediproject.model;

import java.io.Serializable;
import java.util.Objects;


public class ExperienceId implements Serializable {
    private String title;
    private String company_name;
    private Professional professionalId;

    public ExperienceId() { }

    public ExperienceId(String title, String company_name, Professional professionalId) {
        this.title = title;
        this.company_name = company_name;
        this.professionalId = professionalId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public Professional getProfessionalId() {
        return professionalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceId)) return false;
        ExperienceId that = (ExperienceId) o;
        return getTitle().equals(that.getTitle()) && getCompany_name().equals(that.getCompany_name()) && getProfessionalId().equals(that.getProfessionalId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCompany_name(), getProfessionalId());
    }
}
