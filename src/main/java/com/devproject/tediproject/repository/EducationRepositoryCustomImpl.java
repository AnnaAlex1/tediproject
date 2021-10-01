package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EducationRepositoryCustomImpl implements EducationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Education> getAllEducations(Long profId) {

        Query query = entityManager.createQuery(
                "SELECT education\n" +
                        "FROM Education education\n" +
                        "WHERE education.edId.professionalId.id = ?1"
        );
        query.setParameter(1, profId);

        return query.getResultList();
    }


}
