package com.example.videos.repository;

import com.example.videos.model.AppUser;
import com.example.videos.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends AbstractRepository<Tag> {
}
