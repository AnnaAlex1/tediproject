package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.JobPosting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class JobPostingRepositoryCustomImpl implements JobPostingRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<JobPosting> getJobPostingsByFriends(Long profId){

        Query query = entityManager.createQuery(
                "SELECT DISTINCT(jp)\n" +
                        "FROM JobPosting jp,  Professional friend, ConnectionRequest cr\n" +
                        "WHERE (jp.professional.id = friend.id AND \n" +
                        " friend.id = cr.idFromTo.to.id AND cr.idFromTo.from.id=?1 AND cr.fromIsFollowingTo=true)\n" +
                        "ORDER BY jp.date_time DESC"
        );
        query.setParameter(1, profId);
        return query.getResultList();
    }


    @Override
    public List<JobPosting> getJobPostingsByNonFriends(Long profId){

        Query query = entityManager.createQuery(
                "SELECT jp FROM JobPosting jp\n" +
                        "WHERE jp.professional.id NOT IN (SELECT friend FROM ConnectionRequest cr, Professional friend\n" +
                        "WHERE ((cr.idFromTo.to.id = ?1 AND cr.idFromTo.from.id = friend.id AND cr.toIsFollowingFrom = true)\n" +
                        "OR (cr.idFromTo.from.id = ?1 AND cr.idFromTo.to.id = friend.id AND cr.fromIsFollowingTo = true) \n" +
                        "OR friend.id = ?1))"
        );
        query.setParameter(1, profId);
        return query.getResultList();
    }


    @Override
    public List<JobPosting> getMyJobPostings(Long profId){
        Query query = entityManager.createQuery(
                "SELECT DISTINCT(jp)\n" +
                        "FROM JobPosting jp\n" +
                        "WHERE (jp.professional.id = ?1)\n" +
                        "ORDER BY jp.date_time DESC"
        );

        query.setParameter(1, profId);
        return query.getResultList();
    }
}
