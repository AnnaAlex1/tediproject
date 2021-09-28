package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.ConnectionRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ConnectionRequestRepositoryCustomImpl implements ConnectionRequestRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ConnectionRequest> getCRForProf(Long profId){

        Query query = entityManager.createQuery(
                "SELECT c FROM ConnectionRequest c\n" +
                        "WHERE c.idFromTo.to.id = ?1 AND c.fromIsFollowingTo = false"
        );
        query.setParameter(1, profId);
        return query.getResultList();
    }

    @Override
    public void deleteConnectionRequest(Long fromId, Long toId){
        Query query = entityManager.createQuery(
                "DELETE FROM ConnectionRequest c\n" +
                        "WHERE c.idFromTo.from.id = ?1 AND c.idFromTo.to.id=?2"
        );
        query.setParameter(1, fromId);
        query.setParameter(2, toId);
        query.executeUpdate();
    }
}
