package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Institution;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InstitutionDao implements Dao<Institution>{

    private List<Institution> institutions = new ArrayList<>();

    public InstitutionDao(List<Institution> institutions) {
        this.institutions = institutions;
    }


    @Override
    public Optional<Institution> get(long id){
        return Optional.ofNullable(institutions.get(int)id);
    }

    @Override
    public List<Institution> getAll(){
        return institutions;
    }

    @Override
    public void insert(Institution institution){
        institutions.add(institution);
    }

    @Override
    public void update(Institution institution, String[] params){
        institution.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        institutions.add(institution);
    }

    @Override
    public void delete(Institution institution){
        institutions.remove(institution);
    }

}
