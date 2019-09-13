package com.example.videos.rest;

import com.example.videos.model.Video;
import com.example.videos.service.VideoService;
import org.assertj.core.internal.Longs;
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

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

@RestController
@RequestMapping(value = "/api/files/videos")
public class VideoFilesController {
    @Value("${upload.path.videos}")
    private String VIDEOS_PATH;

    @Autowired
    private VideoService videoService;


//    @GetMapping(value = "/file-name")
    @ResponseBody
    public final ResponseEntity<InputStreamResource> retrieveResource() throws IOException {

//        long rangeStart = Longs.tryParse(range.replace("bytes=","").split("-")[0]);//parse range header, which is bytes=0-10000 or something like that
//        long rangeEnd = Longs.tryParse(range.replace("bytes=","").split("-")[0]);//parse range header, which is bytes=0-10000 or something like that
        long contentLenght = 500;//you must have it somewhere stored or read the full file size

        InputStream inputStream = getClass().getResource("videos/GL010034.lrv").openStream();//or read from wherever your data is into stream
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/mp4"));
        headers.set("Accept-Ranges", "bytes");
        headers.set("Expires", "0");
        headers.set("Cache-Control", "no-cache, no-store");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Transfer-Encoding", "binary");
//        headers.set("Content-Length", String.valueOf(rangeEnd - rangeStart));

//if start range assume that all content
//        if (rangeStart == 0) {
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, OK);
//        } /*else {
//            headers.set("Content-Range", format("bytes %s-%s/%s", rangeStart, rangeEnd, contentLenght));
//            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, PARTIAL_CONTENT);
//        }*/
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload (@RequestParam("file") MultipartFile[] files) {
        for ( MultipartFile file : Arrays.asList(files) ) {

            if (file.isEmpty()) {
                continue;
            }
            if ( !file.getContentType().equals("video/mp4") ) {
                continue;
            }
//            if (!"application/pdf".equals(file.getContentType())) {
//                continue;
//            }
            // Save the actual Images

            try {
                Files.write(Paths.get(VIDEOS_PATH + "/" + file.getOriginalFilename()), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                videoService.save(new Video(file.getOriginalFilename()));
            }
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
    private String getExtension(String originalFilename) {
        String[] tokens = originalFilename.split("\\.");
        return "." + tokens[tokens.length - 1];
    }

    @RequestMapping
    public ResponseEntity<?> streamVideo(@RequestParam Long id) throws IOException {

        Optional<Video> video = videoService.findOne(id);
        File videoFile = new File(VIDEOS_PATH + video.get().getName());



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
