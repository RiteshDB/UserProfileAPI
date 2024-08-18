package com.ridham.userProfile.dao;

import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.exception.RecordNotFoundException;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao implements IUserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDao(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public User save(User user) {
        //Transient state
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        //Persistance state;
        transaction.commit();

        //Detached state
        session.close();

        return user;
    }

    @Override
    public Optional<User> findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        Optional<User> user1 = Optional.ofNullable(user);
        transaction.commit();
        session.close();
        return user1;

    }

    @Override
    public User findByFirstName(String firstName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, firstName);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();;
        session.close();
        return user;
    }

    @Override
    public User delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User mergedUser = session.merge(user);
        session.delete(user);
        return user;
    }
}
