package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Professional;

import java.util.List;

public interface ProfessionalRepositoryCustom {
    public List<Professional> getFollowing(Long id);
}
