package com.janis.usersservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.janis.usersservice.entity.User;
import com.janis.usersservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userToUpdate.setName(user.getName());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setEmail(user.getEmail());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }
}

