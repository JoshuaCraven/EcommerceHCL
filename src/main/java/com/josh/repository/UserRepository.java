package com.josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String username);//custom methods
}