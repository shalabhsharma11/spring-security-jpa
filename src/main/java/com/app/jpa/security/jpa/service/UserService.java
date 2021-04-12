package com.app.jpa.security.jpa.service;

import com.app.jpa.security.jpa.entity.User;
import com.app.jpa.security.jpa.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findUserByName(String name){
        return userRepository.findByName(name);
    }

}
