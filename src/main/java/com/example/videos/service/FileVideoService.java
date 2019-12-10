package com.example.videos.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileVideoService {
    void writeVideoFiles(MultipartFile[] files) throws IOException;
    ResponseEntity<InputStreamResource> streamVideo(Long videoId) throws FileNotFoundException;
}
