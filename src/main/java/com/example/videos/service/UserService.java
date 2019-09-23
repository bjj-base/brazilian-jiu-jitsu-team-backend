package com.example.videos.service;

import com.example.videos.model.appUser.UserModel;
import com.example.videos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    public Iterable<UserModel> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findOne(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
