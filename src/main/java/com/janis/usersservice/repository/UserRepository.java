package com.janis.usersservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janis.usersservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
}