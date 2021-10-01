package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ProfessionalSignInRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProfessionalRepositoryCustomImpl implements ProfessionalRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Professional> getFollowing(Long id){
        Query query = entityManager.createQuery(
                "SELECT fr\n" +
                        "FROM Professional pro, Professional fr, ConnectionRequest con\n" +
                        "WHERE (pro.id = con.idFromTo.from.id AND con.idFromTo.to.id = fr.id AND con.fromIsFollowingTo = true AND pro.id = ?1) \n" +
                        "OR (pro.id = con.idFromTo.to.id AND con.idFromTo.from.id = fr.id AND con.toIsFollowingFrom = true AND pro.id = ?1)"
                );
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public Professional findByUsername(String username) {
        Professional user = null;
        Query query = entityManager.createQuery("SELECT u FROM Professional u WHERE u.username = ?1");
        query.setParameter(1, username);
        List<Professional> users = query.getResultList();
        if (users != null && users.size() > 0)
            user = users.get(0);
        return user;
    }

    @Override
    public List<Professional> getAllExceptFriends(Long id){

        Query query = entityManager.createQuery(
                "SELECT users FROM Professional users\n" +
                        "WHERE users.id NOT IN (SELECT friend FROM ConnectionRequest cr, Professional friend\n" +
                        "WHERE ((cr.idFromTo.to.id = ?1 AND cr.idFromTo.from.id = friend.id AND cr.toIsFollowingFrom = true)\n" +
                        "OR (cr.idFromTo.from.id = ?1 AND cr.idFromTo.to.id = friend.id AND cr.fromIsFollowingTo = true) \n" +
                        "OR friend.id = ?1))"
        );
        query.setParameter(1, id);
        return query.getResultList();
    }



}
