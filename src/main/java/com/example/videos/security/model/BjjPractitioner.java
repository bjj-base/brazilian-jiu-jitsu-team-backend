package com.example.videos.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BjjPractitioner implements UserDetails {
    private String password;
    private String username;
    private Boolean enabled = true;
    private Boolean credentialsNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean accountNonExpired = true;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public BjjPractitioner(String username, String password, Boolean enabled, List<GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
