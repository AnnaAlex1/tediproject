package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Education;

import java.util.List;

public interface EducationRepositoryCustom {
    public List<Education> getAllEducations(Long profId);
}
