package com.examle.springcrud.dao;


import com.examle.springcrud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);

    }


    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


}

