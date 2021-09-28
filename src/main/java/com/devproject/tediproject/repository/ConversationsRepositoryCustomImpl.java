package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Conversations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ConversationsRepositoryCustomImpl implements ConversationsRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Conversations> getConversationsByProf1(Long profId){

//        Query query = entityManager.createQuery(
//                "SELECT DISTINCT(c)\n" +
//                        "FROM Conversations c\n" +
//                        "WHERE (c.professional1.id = ?1) \n" +
//                        "ORDER BY c.last_message.date_time DESC"
//        );
        Query query = entityManager.createQuery(
                "SELECT DISTINCT(c)\n" +
                        "FROM Conversations c\n" +
                        "WHERE (c.professional1.id = ?1 OR c.professional2.id = ?1)"
        );
        query.setParameter(1, profId);
        return query.getResultList();
    }
}
