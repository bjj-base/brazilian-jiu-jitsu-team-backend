package com.example.videos.service;

import com.example.videos.dto.RegisterDto;
import com.example.videos.model.appUser.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    AppUser saveNewUser(RegisterDto registerDto);

    List<AppUser> findAll();

    Optional<AppUser> findByUsername(String username);



}
