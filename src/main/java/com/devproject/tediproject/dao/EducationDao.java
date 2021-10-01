package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Education;

import java.time.LocalDate;
import java.util.*;

public class EducationDao implements Dao<Education>{

    private List<Education> education_recs = new ArrayList<>();

    public EducationDao(List<Education> education_recs) {
        this.education_recs = education_recs;
    }


    @Override
    public Optional<Education> get(long id){
        return Optional.ofNullable(education_recs.get((int)id));
    }

    @Override
    public List<Education> getAll(){
        return education_recs;
    }

    @Override
    public void insert(Education education_rec){
        education_recs.add(education_rec);
    }

    @Override
    public void update(Education education_rec, String[] params){
        education_rec.setType(Objects.requireNonNull(params[1], "Type cannot be null"));
        education_rec.setGrade(Float.parseFloat(params[2]));
        education_rec.setDate(LocalDate.parse(params[3]));
        education_recs.add(education_rec);
    }

    @Override
    public void delete(Education education_rec){
        education_recs.remove(education_rec);
    }

}
