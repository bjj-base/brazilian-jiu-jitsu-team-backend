package com.example.videos.service.implementation;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.weekArrangement.DayRange;
import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;
import com.example.videos.model.weekArrangement.WeekArrangement;
import com.example.videos.repository.WeekArrangementRepository;
import com.example.videos.controllers.View;
import com.example.videos.service.TagService;
import com.example.videos.service.VideoService;
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


    public WeekArrangement save(WeekArrangementDto dto) {
        WeekArrangement weekArrangement = new WeekArrangement();
        BeanUtils.copyProperties(dto, weekArrangement);
        weekArrangement.setTags(new HashSet<>(tagService.findAllById(dto.getTagIdList())));

        List<Video> videos = videoService.findAllById(dto.getSelectedVideoIds());
       DayRange dayRange = new DayRange(dto.getDayRange().getStartDate(), dto.getDayRange().getEndDate());
        weekArrangement.setDayRange(dayRange);
        weekArrangement.setVideos(videos);
        return weekArrangementRepository.save(weekArrangement);

    }

    public List<WeekArrangement> findAll(){
        return weekArrangementRepository.findAll();
    }


    public WeekArrangementDto findOneByIdToDto(Long id, View view) {
        Optional<WeekArrangement> weekArrangement = findOneById(id);
        if( weekArrangement.isPresent()) {
            DayRange dayRange = weekArrangement.get().getDayRange();
            if ( view.equals(View.FORM) ) {
                return new WeekArrangementDto.DtoBuilder()
                        .withId(weekArrangement.get().getId())
                        .withDescription(weekArrangement.get().getDescription())
                        .withTagIds(weekArrangement.get().getTags().stream().map(Tag::getId).collect(Collectors.toList()))
                        .withSelectedRange(dayRange)
                        .withSelectedVideoIds(weekArrangement.get().getVideos().stream().map(Video::getId).collect(Collectors.toList()))
                        .build();
            } else if ( view.equals(View.FULL) ) {
//                List<Video> videoDtos =

                return new WeekArrangementDto.DtoBuilder()
                        .withId(weekArrangement.get().getId())
                        .withDescription(weekArrangement.get().getDescription())
//                    .withSelectedDays(weekArrangement.get().getDayRange().)
                        .withName(weekArrangement.get().getName())
                        .withTags(weekArrangement.get().getTags().stream().collect(Collectors.toList()))
                        .withSelectedRange(dayRange)
                        .withVideos(weekArrangement.get().getVideos())
                        .build();
            }
        }
        return null;
    }

    public Optional<WeekArrangement> findOneById(Long id) {
        return weekArrangementRepository.findById(id);
    }
}
