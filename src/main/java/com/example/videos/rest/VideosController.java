package com.example.videos.rest;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Source;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/videos")
public class VideosController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Video> videos = videoService.findAll();
        return ResponseEntity.ok(videos);
    }

    @PostMapping(value = "/external")
    public ResponseEntity<?> postExterrnal(@RequestParam Source source, @RequestBody YoutubeVideo video) {
        video.setSource(source.toString());
        return ResponseEntity.ok(videoService.saveYoutube(video));
    }

    @PostMapping
    public ResponseEntity<?> postBrasaVideo(@RequestParam Source source, @RequestBody BrasaVideo video) {
        video.setSource(source.toString());
        return ResponseEntity.ok(videoService.saveBrasa(video));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVideo(@PathVariable Long id) {
        Optional<BrasaVideo> brasaVideo = videoService.findOneBrasa(id);
        if ( brasaVideo.isPresent() ) return  ResponseEntity.ok(brasaVideo.get());
        Optional<YoutubeVideo> youtubeVideo = videoService.findOneYoutube(id);
        if ( youtubeVideo.isPresent() ) return  ResponseEntity.ok(youtubeVideo.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }





}
