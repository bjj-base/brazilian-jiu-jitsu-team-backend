package com.example.videos.repository;

import com.example.videos.model.appUser.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}
