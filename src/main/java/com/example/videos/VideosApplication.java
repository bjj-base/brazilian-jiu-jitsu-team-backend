package com.example.videos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideosApplication {

    public static void main(String[] args) {
        System.out.println("started");
        SpringApplication.run(VideosApplication.class, args);
    }

}
