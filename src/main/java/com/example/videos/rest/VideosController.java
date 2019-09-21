package com.example.videos.rest;

import com.example.videos.dto.VideoDto;
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
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;

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
        return ResponseEntity.ok(videoService.saveYoutube(video));
    }

    @PostMapping
    public ResponseEntity<?> postBrasaVideo(@RequestBody BrasaVideo video) {
        return ResponseEntity.ok(videoService.saveBrasa(video));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVideo(@PathVariable Long id) {
        Optional<Video> video = videoService.findOneById(id);
        if ( video.isPresent() ) {
            return ResponseEntity.ok().body(video.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }

    @PutMapping
    public <T extends Video>  ResponseEntity<?> updateVideo ( @RequestBody VideoDto dto ) throws InvocationTargetException, IllegalAccessException {
        Optional<T> video = videoService.findOneById(dto.getId());

        if ( video.isPresent() && video.get().getSource().equals("YOUTUBE")) {
            BeanUtils.copyProperties(video.get(), dto);
            return ResponseEntity.ok(videoService.saveYoutube((YoutubeVideo) video.get()));
        } else if ( video.isPresent() && video.get().getSource().equals("BRASA_HELLAS")) {
            BeanUtils.copyProperties(video.get(), dto);
            return ResponseEntity.ok(videoService.saveBrasa((BrasaVideo) video.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }





}
