package com.devproject.tediproject.model;

import java.io.Serializable;
import java.util.Objects;


public class ExperienceId implements Serializable {
    private String title;
    private String company_name;
    private Professional Professional_idProfessional;

    public ExperienceId(String title, String company_name, Professional professional_idProfessional) {
        this.title = title;
        this.company_name = company_name;
        Professional_idProfessional = professional_idProfessional;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public Professional getProfessional_idProfessional() {
        return Professional_idProfessional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceId)) return false;
        ExperienceId that = (ExperienceId) o;
        return getTitle().equals(that.getTitle()) && getCompany_name().equals(that.getCompany_name()) && getProfessional_idProfessional().equals(that.getProfessional_idProfessional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCompany_name(), getProfessional_idProfessional());
    }
}
