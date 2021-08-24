package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Professional;

import java.util.*;

public class ProfessionalDao implements Dao<Professional>{

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

    @Override
    public void update(Professional professional, String[] params){
        professional.setUsername(Objects.requireNonNull(
                params[0], "Username cannot be null"));
        professional.setPassword(Objects.requireNonNull(params[1], "Password cannot be null"));

        professionals.add(professional);
    }

    @Override
    public void delete(Professional professional){
        professionals.remove(professional);
    }

}
