package com.ridham.userProfile.dao;

import com.ridham.userProfile.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    public List<User> findByFirstName(String firstName);

    public List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
