package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.EducationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, EducationId> {
    public List<Education> findByProfessionalId(Long professionalId);
}
