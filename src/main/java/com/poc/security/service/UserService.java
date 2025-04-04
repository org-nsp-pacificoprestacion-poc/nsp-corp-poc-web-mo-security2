package com.poc.security.service;

import com.poc.security.models.User;
import com.poc.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        var users= userRepository.findAll();
        for (User user : users) {
            System.out.println("User email: " + user.getEmail());
            System.out.println("User credentials: " + user.getPassword());
            log.info("user password: " + user.getPassword());
        }
        return users;
    }
    public User getUsersByEmail(String email) {
        return userRepository.findByEmailWithInjection(email);
    }
}
