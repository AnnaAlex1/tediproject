package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.JobPosting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JobPostingDao implements Dao<JobPosting>{

    private List<JobPosting> job_postings = new ArrayList<>();

    public JobPostingDao(List<JobPosting> job_postings) {
        this.job_postings = job_postings;
    }



    @Override
    public Optional<JobPosting> get(long id){
        return Optional.ofNullable(job_postings.get(int)id);
    }

    @Override
    public List<JobPosting> getAll(){
        return job_postings;
    }

    @Override
    public void insert(JobPosting job_posting){
        job_postings.add(job_posting);
    }

    @Override
    public void update(JobPosting job_posting, String[] params){
        job_posting.setText(Objects.requireNonNull(
                params[0], "Text cannot be empty"));
        job_postings.add(job_posting);
    }

    @Override
    public void delete(JobPosting job_posting){
        job_postings.remove(job_posting);
    }

}
