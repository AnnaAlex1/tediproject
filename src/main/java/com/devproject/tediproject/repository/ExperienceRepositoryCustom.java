package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Experience;

import java.util.List;

public interface ExperienceRepositoryCustom {
    public List<Experience> getAllExperience(Long id);
}
