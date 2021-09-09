package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Experience;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExperienceDao implements Dao<Experience>{


    private List<Experience> experience_recs = new ArrayList<>();

    public ExperienceDao(List<Experience> experience_recs) {
        this.experience_recs = experience_recs;
    }

    @Override
    public Optional<Experience> get(long id){
        return Optional.ofNullable(experience_recs.get((int)id));
    }

    @Override
    public List<Experience> getAll(){
        return experience_recs;
    }

    @Override
    public void insert(Experience experience_rec){
        experience_recs.add(experience_rec);
    }

    @Override
    public void update(Experience experience_rec, String[] params){
        experience_rec.setTitle(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        experience_rec.setCompany_name(Objects.requireNonNull(params[1], "Company Name cannot be null"));
        experience_rec.setStart_date(LocalDate.parse(params[2]));
        experience_rec.setEnd_date(LocalDate.parse(params[3]));
        experience_recs.add(experience_rec);
    }

    @Override
    public void delete(Experience experience_rec){
        experience_recs.remove(experience_rec);
    }

}
