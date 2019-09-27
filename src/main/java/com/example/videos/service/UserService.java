package com.example.videos.service;

import com.example.videos.dto.RegisterDto;
import com.example.videos.model.appUser.AppUser;
import com.example.videos.model.appUser.Role;
import com.example.videos.model.appUser.RoleEnum;
import com.example.videos.repository.RoleRepository;
import com.example.videos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser save(RegisterDto dto) {
        AppUser user = new AppUser(dto.getUsername(), passwordEncoder.encode(dto.getPassword()));
        Role role = roleRepository.findByName(RoleEnum.USER);
        user.setRole(role);
        return save(user);
    }

    public List<AppUser> findAll(){
        return userRepository.findAll();
    }

    public Optional<AppUser> findOne(Long id) {
        return userRepository.findById(id);
    }

    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
