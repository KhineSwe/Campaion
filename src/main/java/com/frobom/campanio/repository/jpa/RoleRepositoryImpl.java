package com.frobom.campanio.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.frobom.campanio.entity.Role;
import com.frobom.campanio.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private static final String DEFAULT_ROLE_NAME = "USER";

    private static final String ADMIN_ROLE_NAME = "ADMIN";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Role role) {

    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public Role findByName(String name) {
        Role role = null;
        try {
            Query query = entityManager.createQuery("SELECT role FROM Role role WHERE role.name=?");
            query.setParameter(1, name);
            role = (Role) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role getDefaultRole() {
        return findByName(DEFAULT_ROLE_NAME);
    }

    @Override
    public Role getAdminRole() {
        return findByName(ADMIN_ROLE_NAME);
    }

}
