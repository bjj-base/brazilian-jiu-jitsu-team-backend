package com.example.videos.repository;

import com.example.videos.model.video.YoutubeVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface YoutubeVideoRepository extends VideoRepository<YoutubeVideo> {

}
