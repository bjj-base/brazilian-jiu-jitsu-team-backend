package com.example.videos.service;

import com.example.videos.model.Video;
import com.example.videos.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public Video save(Video video) {
        return videoRepository.save(video);
    }

    public Iterable<Video> findAll(){
        return videoRepository.findAll();
    }

    public Optional<Video> findOne(Long id) {
        return videoRepository.findById(id);
    }
}
