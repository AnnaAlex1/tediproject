package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.EducationId;
import com.devproject.tediproject.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, EducationId>, EducationRepositoryCustom {
//    public List<Education> findByProfessionalId(Long professionalId);
//    public List<Education> findDistinctByEdId_ProfessionalId_Id(Long profId);
//    public  List<Education> findByEdId_ProfessionalId(Professional prof);
}
