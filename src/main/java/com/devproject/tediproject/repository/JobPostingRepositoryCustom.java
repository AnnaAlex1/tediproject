package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.JobPosting;

import java.util.List;

public interface JobPostingRepositoryCustom {

    public List<JobPosting> getJobPostingsByFriends(Long profId);

    public List<JobPosting> getJobPostingsByNonFriends(Long profId);

    public List<JobPosting> getMyJobPostings(Long profId);
}
