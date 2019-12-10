package com.example.videos.controllers;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/files/videos")
public class VideoFilesController {
    @Value("${upload.path.videos}")
    private String VIDEOS_PATH;

    @Autowired
    private VideoService videoService;

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload (@RequestParam("file") MultipartFile[] files) {
        for ( MultipartFile file : Arrays.asList(files) ) {
            if (file.isEmpty()) {
                continue;
            }
            if ( !file.getContentType().equals("video/mp4") ) {
                continue;
            }
            String uuid = UUID.randomUUID().toString();
            try {
                Files.write(Paths.get(VIDEOS_PATH + "/" + uuid), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return ResponseEntity.ok(videoService.saveBrasaVideo(new BrasaVideo(uuid, file.getOriginalFilename())));
            }
        }
        return ResponseEntity.ok("TODO");
    }
    private String getExtension(String originalFilename) {
        String[] tokens = originalFilename.split("\\.");
        return "." + tokens[tokens.length - 1];
    }

    @RequestMapping
    public ResponseEntity<?> streamVideo(@RequestParam Long id) throws IOException {

        Optional<BrasaVideo> video = videoService.findOneBrasa(id);
        File videoFile = new File(VIDEOS_PATH + video.get().getUuid());



        InputStream inputStream = new FileInputStream(videoFile.getPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/mp4"));
        headers.set("Accept-Ranges", "bytes");
        headers.set("Expires", "0");
        headers.set("Cache-Control", "no-cache, no-store");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Transfer-Encoding", "binary");
        return new ResponseEntity<>(new InputStreamResource(inputStream), headers, OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test (){
        System.out.println("we are in");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
