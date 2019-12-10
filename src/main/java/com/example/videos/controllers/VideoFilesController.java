package com.example.videos.controllers;

import com.example.videos.service.FileVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/files/videos")
public class VideoFilesController {

    private FileVideoService fileVideoService;

    @Autowired
    public VideoFilesController(FileVideoService fileVideoService) {
        this.fileVideoService = fileVideoService;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload (@RequestParam("file") MultipartFile[] files) throws IOException {
        fileVideoService.writeVideoFiles(files);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @RequestMapping
    public ResponseEntity<?> streamVideo(@RequestParam Long id) throws IOException {
        return fileVideoService.streamVideo(id);
    }

}
