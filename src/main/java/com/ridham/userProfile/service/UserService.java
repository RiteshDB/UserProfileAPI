package com.ridham.userProfile.service;

import com.ridham.userProfile.dao.UserDao;
import com.ridham.userProfile.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;
    @Override
    public User addUser(User user) {
        User addedUser = userDao.save(user);
        return addedUser;
    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user = userDao.findById(id);
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> user = userDao.findByFirstName(name);
        return user;
    }

    @Override
    public List<User> getUserByFirstNameLastName(String firstName, String lastName) {
        List<User> user = userDao.findByFirstNameAndLastName(firstName, lastName);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
