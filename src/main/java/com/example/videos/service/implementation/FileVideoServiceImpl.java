package com.example.videos.service.implementation;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.service.FileVideoService;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Service
public class FileVideoServiceImpl implements FileVideoService {

    private String VIDEOS_PATH;
    private VideoService videoService;

    @Autowired
    public FileVideoServiceImpl(@Value("${upload.path.videos}") String VIDEOS_PATH, VideoService videoService) {
        this.VIDEOS_PATH = VIDEOS_PATH;
        this.videoService = videoService;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void writeVideoFiles(MultipartFile[] files) throws IOException {
        for ( MultipartFile file : Arrays.asList(files) ) {
            if (file.isEmpty()) {
                continue;
            }
            if ( !file.getContentType().equals("video/mp4") ) {
                continue;
            }
            String uuid = UUID.randomUUID().toString();
            Files.write(Paths.get(VIDEOS_PATH + "/" + uuid), file.getBytes());
            videoService.saveBrasaVideo(new BrasaVideo(uuid, file.getOriginalFilename()));
        }
    }

    @Override
    public ResponseEntity<InputStreamResource> streamVideo(Long videoId) throws FileNotFoundException {
        Optional<BrasaVideo> video = videoService.findOneBrasa(videoId);
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
}
