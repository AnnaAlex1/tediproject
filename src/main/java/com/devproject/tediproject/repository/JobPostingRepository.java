package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.JobPosting;
import com.devproject.tediproject.payload.JobPostingAddRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long>, JobPostingRepositoryCustom {
}
