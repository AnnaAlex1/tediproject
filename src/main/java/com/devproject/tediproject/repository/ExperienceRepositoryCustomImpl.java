package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.Experience;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ExperienceRepositoryCustomImpl implements ExperienceRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public List<Experience> getAllExperience(Long id){

        Query query = entityManager.createQuery(
                "SELECT experience\n" +
                        "FROM Experience experience\n" +
                        "WHERE experience.expId.professionalId.id = ?1"
        );
        query.setParameter(1, id);

        return query.getResultList();
    }

}
