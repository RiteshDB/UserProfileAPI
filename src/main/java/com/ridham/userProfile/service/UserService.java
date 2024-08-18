package com.ridham.userProfile.service;

import com.ridham.userProfile.dao.UserDao;
import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public User getUserById(int id) throws RecordNotFoundException {
        Optional<User> user = userDao.findById(id);
        User user1 = user.orElseThrow(()->new RecordNotFoundException("The system not contains any user with user id: "+id));
        return user1;
    }


    @Override
    public User getUserByName(String name) {
        User user = userDao.findByFirstName(name);
        return user;
    }
    /*@Override
    public List<User> getUserByFirstNameLastName(String firstName, String lastName) {
        List<User> user = userDao.findByFirstNameAndLastName(firstName, lastName);
        return user;
    }*/

    /*@Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }*/

    @Override
    public User updateUser(User user) {
        User updatedUser = userDao.updateUser(user);
        return updatedUser;
    }

    @Override
    public User delete(User user) {
        User deletedUser = userDao.delete(user);
        return deletedUser;
    }
}
