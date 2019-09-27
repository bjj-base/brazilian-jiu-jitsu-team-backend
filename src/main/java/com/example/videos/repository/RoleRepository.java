package com.example.videos.repository;

import com.example.videos.model.appUser.Role;
import com.example.videos.model.appUser.RoleEnum;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends AbstractRepository<Role> {
    Role findByName(RoleEnum name);
}
