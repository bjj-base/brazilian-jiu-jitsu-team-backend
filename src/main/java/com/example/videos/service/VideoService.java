package com.example.videos.service;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.repository.BrasaVideoRepository;
import com.example.videos.repository.YoutubeVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {
    @Autowired
    private BrasaVideoRepository brasaVideoRepository;

    @Autowired
    private YoutubeVideoRepository youtubeVideoRepository;


    /**
     *
     * @return
     */
    public List<Video> findAll(){
        List<Video> videos = new ArrayList<>();
        videos.addAll(brasaVideoRepository.findAll());
//                findAllBrasa()
//                .stream()
//                .map(v -> (Video)v)
//                .collect(Collectors.toList());
        videos.addAll(youtubeVideoRepository.findAll());
        return videos;
    }

    /**
     *
     * @param video
     * @return
     */
    public BrasaVideo saveBrasa(BrasaVideo video) {
        return brasaVideoRepository.save(video);
    }

    /**
     *
     * @return
     */
    public List<BrasaVideo> findAllBrasa(){
        return brasaVideoRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */

    public Optional<BrasaVideo> findOneBrasa(Long id) {
        return brasaVideoRepository.findById(id);
    }

    /**
     *
     * @param video
     * @return
     */

    public YoutubeVideo saveYoutube(YoutubeVideo video) {
        return youtubeVideoRepository.save(video);
    }

    /**
     *
     * @return
     */
    public List<YoutubeVideo> findAllYoutube(){
        return youtubeVideoRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<YoutubeVideo> findOneYoutube(Long id) {
        return youtubeVideoRepository.findById(id);
    }


}
