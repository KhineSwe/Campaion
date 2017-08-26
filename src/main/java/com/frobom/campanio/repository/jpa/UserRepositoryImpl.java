package com.frobom.campanio.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.frobom.campanio.entity.User;
import com.frobom.campanio.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        if (user.isNew()) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?");
            query.setParameter(1, email);
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

}
