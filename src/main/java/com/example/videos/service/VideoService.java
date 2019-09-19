package com.example.videos.service;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.repository.BrasaVideoRepository;
import com.example.videos.repository.YoutubeVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private BrasaVideoRepository brasaVideoRepository;

    @Autowired
    private YoutubeVideoRepository youtubeVideoRepository;



    public BrasaVideo saveBrasa(BrasaVideo video) {
        return brasaVideoRepository.save(video);
    }

    public Iterable<BrasaVideo> findAllBrasa(){
        return brasaVideoRepository.findAll();
    }

    public Optional<BrasaVideo> findOneBrasa(Long id) {
        return brasaVideoRepository.findById(id);
    }

    public YoutubeVideo saveYoutube(YoutubeVideo video) {
        return youtubeVideoRepository.save(video);
    }

    public Iterable<BrasaVideo> findAllYoutube(){
        return brasaVideoRepository.findAll();
    }

    public Optional<BrasaVideo> findOneYoutube(Long id) {
        return brasaVideoRepository.findById(id);
    }


}
