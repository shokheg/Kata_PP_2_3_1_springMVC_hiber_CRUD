package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author shokhalevich
 */

@Repository
public class UserDAO {
    @PersistenceContext
    private EntityManager em;


    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();

    }

    @Transactional
    public void add(User user) {
        em.persist(user);
    }

    @Transactional
    public void updateUser(User user) {
        em.merge(user);
        em.flush();
    }

    @Transactional
    public User delete(User user) {
        if (em.contains(user)) {
            em.remove(user);
        } else {
            em.remove(em.merge(user));
        }

        return user;
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return em.find(User.class, id);
    }
}
