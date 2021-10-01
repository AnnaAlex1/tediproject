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

/*    @Override
    public List<Education> getAllEducations(Long profId) {

        Query query = entityManager.createQuery(
                *//*"SELECT DISTINCT(e) \n" +
                        "FROM Education e\n" +
                        "WHERE (e.edId.professionalId.id = ?1)"*//*
                        *//*"FROM Education e, Professional p\n" +
                        "WHERE (p.id = ?1) AND (e.edId.professionalId.id = ?1)"*//*
                        *//*"FROM Education e, Professional p\n" +
                        "WHERE (p.id = ?1) AND (e.edId.professionalId = p)"*//*
                "SELECT * FROM Education edu WHERE edu.professional_id_id = ?1"
        );
        query.setParameter(1, profId);

        return query.getResultList();
    }*/

    @Override
    public  List<Education> getAllEducations(Long profId) {

        List<Education> dbWeapons = new ArrayList<>();
        /*EntityTransaction entr= entityManager.getTransaction();
        entr.begin();*/
//        TypedQuery<Education> query = entityManager.createQuery("SELECT i FROM Education i", Education.class);
        TypedQuery<Education> query = entityManager.createQuery("SELECT i FROM Education i where i.edId.professionalId.id = :professional_id_id", Education.class);
        query.setParameter("professional_id_id", profId);
        dbWeapons = query.getResultList();
//        entityManager.getTransaction().commit();

        return dbWeapons;
    }

}