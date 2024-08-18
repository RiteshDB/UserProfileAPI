package com.ridham.userProfile.dao;

import com.ridham.userProfile.entities.User;

import java.util.Optional;

public interface IUserDao {

    User save(User user);

    Optional<User> findById(int id);

    User findByFirstName(String firstName);

    User updateUser(User user);

    User delete(User user);

}
