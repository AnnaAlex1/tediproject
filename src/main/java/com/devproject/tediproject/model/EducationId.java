package com.devproject.tediproject.model;

import java.io.Serializable;
import java.util.Objects;


public class EducationId implements Serializable {

    private String title;
    private String institution_name;
    private Professional professional_idProfessional;

    public EducationId(String title, String institution_name, Professional professional_idProfessional) {
        this.title = title;
        this.institution_name = institution_name;
        this.professional_idProfessional = professional_idProfessional;
    }

    public String getTitle() {
        return title;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public Professional getProfessional_idProfessional() {
        return professional_idProfessional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationId)) return false;
        EducationId that = (EducationId) o;
        return getTitle().equals(that.getTitle()) && getInstitution_name().equals(that.getInstitution_name()) && getProfessional_idProfessional().equals(that.getProfessional_idProfessional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getInstitution_name(), getProfessional_idProfessional());
    }
}
