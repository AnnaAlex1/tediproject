package com.devproject.tediproject.repository;


import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ProfessionalAddRequest;
import com.devproject.tediproject.payload.ProfessionalSignInRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long>, ProfessionalRepositoryCustom {

    Professional findProfessionalByEmailAndPassword(String email, String password);
}
