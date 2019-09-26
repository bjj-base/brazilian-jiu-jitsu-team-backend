package com.example.videos.dto;

import com.example.videos.model.video.Video;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class WeekArrangementDto extends BaseModelDto {
    private List<Long> selectedVideos;
    private List<LocalDate> selectedDays;
    private String description;
    private List<Long> tagIdList;
}
