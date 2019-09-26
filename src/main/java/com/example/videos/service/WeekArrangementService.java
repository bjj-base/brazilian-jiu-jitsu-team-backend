package com.example.videos.service;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.WeekArrangement;
import com.example.videos.repository.TagRepository;
import com.example.videos.repository.VideoRepository;
import com.example.videos.repository.WeekArrangementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeekArrangementService {
    @Autowired
    private WeekArrangementRepository weekArrangementRepository;

    @Autowired
    private VideoService videoService;

    @Autowired
    private TagService tagService;

    public WeekArrangement save(WeekArrangement tag) {
        return weekArrangementRepository.save(tag);
    }

    public WeekArrangement save(WeekArrangementDto dto) {
        WeekArrangement weekArrangement = new WeekArrangement();
        BeanUtils.copyProperties(dto, weekArrangement);
        weekArrangement.setTags(new HashSet<>(tagService.findAllById(dto.getTagIdList())));

        List<Video> videos = videoService.findAllById(dto.getSelectedVideos());

        weekArrangement.setVideos(videos.stream().collect(Collectors.toSet()));
        weekArrangementRepository.save(weekArrangement);
        System.out.println(weekArrangement);
        return weekArrangement;
    }

    public List<WeekArrangement> findAll(){
        return weekArrangementRepository.findAll();
    }


    public Optional<WeekArrangement> findOneById(Long id) {
        return weekArrangementRepository.findById(id);
    }
}
