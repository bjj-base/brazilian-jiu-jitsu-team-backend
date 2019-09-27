package com.example.videos.dto;

import com.example.videos.model.video.Video;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class WeekArrangementDto extends BaseModelDto {
    private List<Long> selectedVideos;
    private List<LocalDate> selectedDays;
    private List<Long> tagIdList;

    private WeekArrangementDto(Long id, String description, String name, List<Long> selectedVideos, List<LocalDate> selectedDays,  List<Long> tagIdList) {
        super(id, name, description);
        this.selectedVideos = selectedVideos;
        this.selectedDays = selectedDays;
        this.tagIdList = tagIdList;
    }

    public static class DtoBuilder{
        private List<Long> selectedVideos;
        private List<LocalDate> selectedDays;
        private List<Long> tagIdList;

        private Long id;
        private String description;
        private String name;


        public DtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DtoBuilder withSelectedDays(List<LocalDate> selectedDays) {
            this.selectedDays = selectedDays;
            return this;
        }
        public DtoBuilder withSelectedVideos(List<Long> selectedVideos) {
            this.selectedVideos = selectedVideos;
            return this;
        }
        public DtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }
        public DtoBuilder withTags(List<Long> tags) {
            this.tagIdList = tags;
            return this;
        }

        public WeekArrangementDto build(){
            return new WeekArrangementDto(id, description, name, selectedVideos, selectedDays, tagIdList);
        }





    }
}
