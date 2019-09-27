package com.example.videos.repository;

import com.example.videos.model.appUser.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<AppUser> {
    Optional<AppUser> findByUsername(String username);
}
