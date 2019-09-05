package com.example.videos.rest;

import org.assertj.core.internal.Longs;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

@RestController
@RequestMapping(value = "/videos")
public class VideosController {
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

    @RequestMapping(value = "/hello")
    public ResponseEntity<?> sayHello() throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResource("videos3/fifth.mp4").openStream();
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
