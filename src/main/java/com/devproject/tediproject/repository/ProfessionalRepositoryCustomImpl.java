package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Professional;
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
                        "WHERE pro.id = con.idFromTo.from.id AND con.idFromTo.to.id = fr.id AND con.fromIsFollowingTo = true AND pro.id = ?1");
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
}
