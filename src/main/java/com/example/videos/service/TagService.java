package com.example.videos.service;

import com.example.videos.model.tags.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag save(Tag tag);
    List<Tag> findAll();
    List<Tag> findAllById(List<Long> ids);
    Optional<Tag> findOneById(Long id);

}
