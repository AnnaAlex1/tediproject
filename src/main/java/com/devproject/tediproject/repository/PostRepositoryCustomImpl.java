
package com.devproject.tediproject.repository;


import com.devproject.tediproject.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getPostsInFeed(Long profId) {

        Query query = entityManager.createQuery(
                "SELECT DISTINCT p\n" +
                        "FROM Post p,  Professional friend, ConnectionRequest cr, Comment c, Like l\n" +
                        "WHERE (p.prof.id = ?1)\n" +
                        "OR (p.prof.id = friend.id AND \n" +
                        " friend.id = cr.idFromTo.to.id AND cr.idFromTo.from.id=?1 AND cr.fromIsFollowingTo=true)\n" +
                        "OR ( friend.id = cr.idFromTo.to.id AND cr.idFromTo.from.id=?1 AND cr.fromIsFollowingTo=true \n" +
                        "AND c.postId.idPost = p.idPost AND c.professionalId.id = friend.id )\n" +
                        "OR ( friend.id = cr.idFromTo.to.id AND cr.idFromTo.from.id=?1 AND cr.fromIsFollowingTo=true \n" +
                        "AND l.post.idPost = p.idPost AND l.professional_liked.id = friend.id )\n" +
                        "ORDER BY p.date_time DESC"
        );
        query.setParameter(1, profId);
        return query.getResultList();
    }
}
