package com.ridham.userProfile.dao;

import com.ridham.userProfile.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
