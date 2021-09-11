package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.Experience;
import com.devproject.tediproject.model.Professional;

import java.util.*;

public abstract class ProfessionalDao implements Dao<Professional>{

    private List<Professional> professionals = new ArrayList<>();

    public ProfessionalDao(List<Professional> professionals) {
        this.professionals = professionals;
    }

    @Override
    public Optional<Professional> get(long id){
        return Optional.ofNullable(professionals.get((int)id));
    }

    @Override
    public List<Professional> getAll(){
        return professionals;
    }

    @Override
    public void insert(Professional professional){
        professionals.add(professional);
    }


    public void update(Professional professional, String[] params, List<Experience> experienceList, List<Education> educationList){
        professional.setId(Long.parseLong(params[0]) );
        professional.setUsername(Objects.requireNonNull(
                params[1], "Username cannot be null"));
        professional.setPassword(Objects.requireNonNull(params[2], "Password cannot be null"));
        professional.setName(Objects.requireNonNull(
                params[3], "Name cannot be null"));
        professional.setSurname(Objects.requireNonNull(
                params[4], "Surname cannot be null"));
        professional.setEmail(Objects.requireNonNull(
                params[5], "Email cannot be null"));
        professional.setPhone(params[6]);
        professional.setPicture_url(params[7]);
        professional.setName_surname_public(Boolean.parseBoolean(params[8]));
        professional.setEmail_public(Boolean.parseBoolean(params[9]));
        professional.setPhone_public(Boolean.parseBoolean(params[10]));
//        professional.setEducationList(educationList);
//        professional.setExperienceList(experienceList);

        professionals.add(professional);

    }

    @Override
    public void delete(Professional professional){
        professionals.remove(professional);
    }

}
