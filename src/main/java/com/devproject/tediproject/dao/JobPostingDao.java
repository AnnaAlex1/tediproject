package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.JobPosting;
import com.devproject.tediproject.model.Professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class JobPostingDao implements Dao<JobPosting>{

    private List<JobPosting> jobPostings = new ArrayList<>();

    public JobPostingDao(List<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }


    @Override
    public Optional<JobPosting> get(long id){
        return Optional.ofNullable(jobPostings.get((int)id));
    }

    @Override
    public List<JobPosting> getAll(){
        return jobPostings;
    }

    @Override
    public void insert(JobPosting jobPosting){
        jobPostings.add(jobPosting);
    }


    public void update(JobPosting jobPosting, Long jobPostingId, List<Content> content, Professional professional){
        jobPosting.setIdJobPosting(jobPostingId);
        jobPosting.setContent(content);
        jobPosting.setProfessional_idProfessional(professional);
        jobPostings.add(jobPosting);
    }

    @Override
    public void delete(JobPosting jobPosting){
        jobPostings.remove(jobPosting);
    }

}
