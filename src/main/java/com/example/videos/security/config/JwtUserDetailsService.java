package com.example.videos.security.config;

import com.example.videos.model.appUser.AppUser;
import com.example.videos.security.config.model.BjjPractitioner;
import com.example.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public BjjPractitioner loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("momo".equals(username)) {
            Optional<AppUser> appUser = userService.findByUsername(username);

        if ( appUser.isPresent() ) {
            System.out.println(appUser.get().getUsername());
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(appUser.get().getRole().getName()));
//            return new User("momo", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
            return new BjjPractitioner(
                    appUser.get().getUsername(),
                    appUser.get().getPassword(),
                    true,
                    authorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
