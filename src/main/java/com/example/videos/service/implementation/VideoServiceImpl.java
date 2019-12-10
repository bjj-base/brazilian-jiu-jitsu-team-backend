package com.example.videos.service.implementation;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.repository.BrasaVideoRepository;
import com.example.videos.repository.VideoRepository;
import com.example.videos.repository.YoutubeVideoRepository;
import com.example.videos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl<T extends Video> implements VideoService {
    @Autowired
    private BrasaVideoRepository brasaVideoRepository;

    @Autowired
    private YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> findAll(){
        return videoRepository.findAll();
    }

    @Override
    public List<Video> findAllById(List ids) {
        return videoRepository.findAllById(ids);
    }

    public Optional<T> findOneById(Long id) {
        return videoRepository.findById(id);
    }

    public T save(Video video){
        return (T) videoRepository.save(video);
    }

    /**
     *
     * @param video
     * @return
     */
    public BrasaVideo saveBrasaVideo(BrasaVideo video) {
        return brasaVideoRepository.save(video);
    }

    /**
     *
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

}
