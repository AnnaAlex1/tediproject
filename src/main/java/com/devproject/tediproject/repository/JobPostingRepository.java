package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> { }
