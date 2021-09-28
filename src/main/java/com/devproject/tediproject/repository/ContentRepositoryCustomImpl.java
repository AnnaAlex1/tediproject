package com.devproject.tediproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = false)
public class ContentRepositoryCustomImpl implements ContentRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void deleteByJobPostingId(Long idJobPosting){

        Query query = entityManager.createQuery(
                "DELETE FROM Content c WHERE (c.jobPosting.idJobPosting = ?1)"
        );
        query.setParameter(1, idJobPosting);
        query.executeUpdate();
    }

    @Override
    public void deleteByPostId(Long idPost){
        Query query = entityManager.createQuery(
                "DELETE FROM Content c WHERE (c.post.idPost = ?1)"
        );
        query.setParameter(1, idPost);
        query.executeUpdate();
    }
}
