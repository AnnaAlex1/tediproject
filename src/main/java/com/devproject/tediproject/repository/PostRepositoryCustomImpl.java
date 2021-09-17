
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
//
//        Query query = entityManager.createQuery(
////                "SELECT DISTINCT(p) \n" +
////                "FROM Post p, Professional friend, ConnectionRequest cr, Like l, Comment c\n" +
////                "WHERE (p.prof.id = friend.id AND \n" +
////                "friend.id = cr.to.id AND cr.from.id=?1 AND cr.fromIsFollowingTo=true)\n" +
////                "OR (p.prof.id = ?1) \n" +
////                "OR (friend.id = cr.to.id AND cr.from.id=?1 AND cr.fromIsFollowingTo=true \n" +
////                "AND l.post.idPost = p.idPost AND l.professional_liked.id = friend.id)\n" +
////                "OR (friend.id = cr.to.id AND cr.from.id=?1 AND cr.fromIsFollowingTo=true \n" +
////                "AND c.postId.idPost = p.idPost AND c.professionalId.id = friend.id )\n" +
////                "ORDER BY p.date_time DESC");
//                "SELECT p FROM Post p, Professional friend, ConnectionRequest cr WHERE (p.prof.id = ?1) OR (p.prof.id = friend.id AND \n" +
//                        "friend.id = cr.to.id AND cr.from.id=?1 AND cr.fromIsFollowingTo=true)");
//        query.setParameter(1, profId);
//        return query.getResultList();
        Query query = entityManager.createQuery(
                "SELECT p, c\n" +
                "FROM Post p, Content c\n" +
                "WHERE c.post.idPost = p.idPost AND ((p.prof.id = ?1))");

//        Query query = entityManager.createQuery(
//                "SELECT p FROM Post p WHERE (p.prof.id = ?1) ");
        query.setParameter(1, profId);
        return query.getResultList();
    }
}
