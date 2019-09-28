package com.example.videos.service;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.weekArrangement.DayRange;
import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;
import com.example.videos.model.weekArrangement.WeekArrangement;
import com.example.videos.repository.WeekArrangementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
       DayRange dayRange = new DayRange(dto.getDayRange().getStartDate(), dto.getDayRange().getEndDate());
        weekArrangement.setDayRange(dayRange);
        weekArrangement.setVideos(videos.stream().collect(Collectors.toSet()));
        return weekArrangementRepository.save(weekArrangement);

    }

    public List<WeekArrangement> findAll(){
        return weekArrangementRepository.findAll();
    }


    public WeekArrangementDto findOneByIdToDto(Long id) {
        Optional<WeekArrangement> weekArrangement = findOneById(id);
        if( weekArrangement.isPresent()) {
            DayRange dayRange = weekArrangement.get().getDayRange();

            return new WeekArrangementDto.DtoBuilder()
                    .withId(weekArrangement.get().getId())
                    .withDescription(weekArrangement.get().getDescription())
//                    .withSelectedDays(weekArrangement.get().getDayRange().)
                    .withName(weekArrangement.get().getName())
                    .withTags(weekArrangement.get().getTags().stream().map(Tag::getId).collect(Collectors.toList()))
                    .withSelectedRange(dayRange)
                    .withSelectedVideos(weekArrangement.get().getVideos().stream().map(Video::getId).collect(Collectors.toList()))
                    .build();
        }
        return null;
    }

    public Optional<WeekArrangement> findOneById(Long id) {
        return weekArrangementRepository.findById(id);
    }
}
