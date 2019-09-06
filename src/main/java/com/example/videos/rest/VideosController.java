package com.example.videos.rest;

import com.example.videos.model.Video;
import com.example.videos.repository.VideoRepository;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/videos")
public class VideosController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        Iterable<Video> videos = videoService.findAll();
        return ResponseEntity.ok(videos);
    }




}
