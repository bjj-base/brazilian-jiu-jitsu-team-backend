package com.example.videos.service;

import com.example.videos.model.AppUser;
import com.example.videos.model.Tag;
import com.example.videos.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public Iterable<Tag> findAll(){
        return tagRepository.findAll();
    }

    public Optional<Tag> findOne(Long id) {
        return tagRepository.findById(id);
    }

}
