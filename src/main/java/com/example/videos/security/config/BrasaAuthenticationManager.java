package com.example.videos.security.config;

import com.example.videos.model.appUser.AppUser;
import com.example.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BrasaAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        Optional<AppUser> user = userService.findByUsername(username);
        if ( !user.isPresent()) {
            throw new BadCredentialsException("1000");
        }
//        if (user.isDisabled()) {
//            throw new DisabledException("1001");
//        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ( user.get().getRole() != null ) {
            authorities.add(new SimpleGrantedAuthority(user.get().getRole().getName().toString()));
        }
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new BadCredentialsException("1000");
        }
        return new UsernamePasswordAuthenticationToken(user.get().getUsername(), user.get().getPassword(), authorities);
    }
}

