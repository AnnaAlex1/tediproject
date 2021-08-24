package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Experience;
import com.devproject.tediproject.model.ExperienceId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, ExperienceId> {
    public List<Experience> findByProfessionalId(Long professionalId);
}
