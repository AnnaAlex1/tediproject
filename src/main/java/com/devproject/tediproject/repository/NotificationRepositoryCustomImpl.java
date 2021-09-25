package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Notification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class NotificationRepositoryCustomImpl implements NotificationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Notification> getRestOfNotifications(Long profId){  //get notifications (except connection requests)
        Query query = entityManager.createQuery(
                "SELECT n FROM Notification n \n" +
                        "WHERE n.profId.id = ?1 \n" +
                        "AND n.cRequestNot.idFromTo.from is NULL");
        query.setParameter(1, profId);
        return query.getResultList();
    }
}
