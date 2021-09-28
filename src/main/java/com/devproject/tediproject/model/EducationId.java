package com.devproject.tediproject.model;

import java.io.Serializable;
import java.util.Objects;


public class EducationId implements Serializable {

    private String title;
    private String institution_name;
    private Professional professionalId;

    public EducationId() { }

    public EducationId(String title, String institution_name, Professional professionalId) {
        this.title = title;
        this.institution_name = institution_name;
        this.professionalId = professionalId;
    }

    public String getTitle() {
        return title;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public Professional getProfessionalId() {
        return professionalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationId)) return false;
        EducationId that = (EducationId) o;
        return getTitle().equals(that.getTitle()) && getInstitution_name().equals(that.getInstitution_name()) && getProfessionalId().equals(that.getProfessionalId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getInstitution_name(), getProfessionalId());
    }
}
