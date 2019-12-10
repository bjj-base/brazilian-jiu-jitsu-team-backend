package com.example.videos.service;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;

import java.util.List;
import java.util.Optional;

public interface VideoService<T extends Video> {

    List<Video> findAll();
    List<Video> findAllById(List<Long> ids);
    Optional<T> findOneById(Long id);
    T save(T video);
    BrasaVideo saveBrasaVideo(BrasaVideo video);
    Optional<BrasaVideo> findOneBrasa(Long id);
    YoutubeVideo saveYoutube(YoutubeVideo video);



}
