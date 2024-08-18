package com.ridham.userProfile.service;

import com.ridham.userProfile.entities.User;
import com.ridham.userProfile.exception.RecordNotFoundException;

public interface IUserService {

    User addUser(User user);

    User getUserById(int id) throws RecordNotFoundException;

    User getUserByName(String name);
    /*List<User> getUserByFirstNameLastName(String firstName, String lastName);
     List<User> getAllUsers();*/

    User updateUser(User user);

    User delete(User user);
}
