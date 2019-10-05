package com.example.videos.service;

import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.repository.BrasaVideoRepository;
import com.example.videos.repository.VideoRepository;
import com.example.videos.repository.YoutubeVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService <T extends Video> {
    @Autowired
    private BrasaVideoRepository brasaVideoRepository;

    @Autowired
    private YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> findAllById(List<Long> ids){
        return videoRepository.findAllById(ids);
    }

    /**
     *
     * @return
     */
    public List<Video> findAll(){
        Sort sort = new Sort(Sort.Direction.DESC, "updatedAt");
        return videoRepository.findAll(sort);
    }

    public Optional<T> findOneById(Long id) {
        return videoRepository.findById(id);
    }

    public T save(T video){
        return (T) videoRepository.save(video);
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
