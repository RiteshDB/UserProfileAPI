package com.ridham.userProfile.service;

import com.ridham.userProfile.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

     User addUser(User user);
     Optional<User> getUserById(int id);
    List<User> getUserByName(String name);
    List<User> getUserByFirstNameLastName(String firstName, String lastName);
     List<User> getAllUsers();

     User updateUser(User user);
}
