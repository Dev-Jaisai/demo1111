package com.unitTest.unitTest.service;

import com.unitTest.unitTest.entity.User;
import com.unitTest.unitTest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Method to find a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    // Method to save a new user
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    // Method to update an existing user
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepo.findById(id).map(user -> {
            user.setName(userDetails.getName());
            return userRepo.save(user);
        });
    }

    // Method to delete a user by ID
    public boolean deleteUser(Long id) {
        return userRepo.findById(id).map(user -> {
            userRepo.delete(user);
            return true;
        }).orElse(false);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
