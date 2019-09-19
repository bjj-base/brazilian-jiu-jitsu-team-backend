package com.example.videos.rest;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Source;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/videos")
public class VideosController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        Iterable<BrasaVideo> videos = videoService.findAllBrasa();
        return ResponseEntity.ok(videos);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestParam Source source, @RequestBody YoutubeVideo video) {
        video.setSource(source.toString());
        return ResponseEntity.ok(videoService.saveYoutube(video));
    }




}
