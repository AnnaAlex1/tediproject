package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ProfessionalSignInRequest;

import java.util.List;

public interface ProfessionalRepositoryCustom {
    public List<Professional> getFollowing(Long id);
//    public Professional findProfessionalByEmailAndPassword(ProfessionalSignInRequest req);
}
