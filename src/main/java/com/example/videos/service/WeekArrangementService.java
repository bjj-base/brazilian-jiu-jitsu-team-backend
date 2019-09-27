package com.example.videos.service;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.DayRange;
import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.WeekArrangement;
import com.example.videos.repository.WeekArrangementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
       DayRange dayRange = new DayRange(dto.getSelectedDays().get(0), dto.getSelectedDays().get(6));
        weekArrangement.setDayRange(dayRange);
        weekArrangement.setVideos(videos.stream().collect(Collectors.toSet()));
        return weekArrangementRepository.save(weekArrangement);

    }

    public List<WeekArrangement> findAll(){
        return weekArrangementRepository.findAll();
    }


    public WeekArrangementDto findOneById(Long id) {
        Optional<WeekArrangement> weekArrangement = weekArrangementRepository.findById(id);
        if( weekArrangement.isPresent()) {
            DayRange dayRange = weekArrangement.get().getDayRange();
            List<LocalDate> week = new ArrayList<>();
            week.add(dayRange.getStarting_date());
            week.add(dayRange.getEnding_date());


            return new WeekArrangementDto.DtoBuilder()
                    .withId(weekArrangement.get().getId())
                    .withDescription(weekArrangement.get().getDescription())
//                    .withSelectedDays(weekArrangement.get().getDayRange().)
                    .withName(weekArrangement.get().getName())
                    .withTags(weekArrangement.get().getTags().stream().map(Tag::getId).collect(Collectors.toList()))
                    .withSelectedDays(week)
                    .withSelectedVideos(weekArrangement.get().getVideos().stream().map(Video::getId).collect(Collectors.toList()))
                    .build();
        }
        return null;
    }
}
