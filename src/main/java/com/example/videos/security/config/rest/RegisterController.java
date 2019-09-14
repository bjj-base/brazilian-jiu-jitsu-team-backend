package com.example.videos.security.config.rest;

import com.example.videos.dto.RegisterDto;
import com.example.videos.model.AppUser;
import com.example.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        if ( userService.findByUsername(dto.getUsername()).isPresent() ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(HttpStatus.CONFLICT);
        }
        AppUser user = new AppUser(dto.getUsername(), passwordEncoder.encode(dto.getPassword()));
        userService.save(user);
        System.out.println(passwordEncoder.encode(dto.getPassword()));
        return ResponseEntity.ok(dto);
    }
}
