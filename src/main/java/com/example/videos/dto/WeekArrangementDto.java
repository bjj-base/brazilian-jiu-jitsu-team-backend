package com.example.videos.dto;

import com.example.videos.model.weekArrangement.DayRange;
import lombok.Data;

import java.util.List;

@Data
public class WeekArrangementDto extends BaseModelDto {
    private List<Long> selectedVideos;
    private DayRange dayRange;
    private List<Long> tagIdList;

    private WeekArrangementDto(Long id, String description, String name, List<Long> selectedVideos, DayRange dayRange, List<Long> tagIdList) {
        super(id, name, description);
        this.selectedVideos = selectedVideos;
        this.dayRange = dayRange;
        this.tagIdList = tagIdList;
    }

    public static class DtoBuilder{
        private List<Long> selectedVideos;
        private DayRange dayRange;
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

        public DtoBuilder withSelectedRange(DayRange dayRange) {
            this.dayRange = dayRange;
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
            return new WeekArrangementDto(id, description, name, selectedVideos, dayRange, tagIdList);
        }





    }
}
