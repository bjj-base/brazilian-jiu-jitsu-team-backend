package com.example.videos.service;

import com.example.videos.model.AppUser;
import com.example.videos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    public Iterable<AppUser> findAll(){
        return userRepository.findAll();
    }

    public Optional<AppUser> findOne(Long id) {
        return userRepository.findById(id);
    }

    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
