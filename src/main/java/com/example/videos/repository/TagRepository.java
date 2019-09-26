package com.example.videos.repository;

import com.example.videos.model.tags.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends AbstractRepository<Tag> {

    @Override
    List<Tag> findAllById(Iterable<Long> ids);
}
