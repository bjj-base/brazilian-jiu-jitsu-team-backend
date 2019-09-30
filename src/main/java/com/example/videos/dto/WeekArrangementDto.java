package com.example.videos.dto;

import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;
import com.example.videos.model.weekArrangement.DayRange;
import lombok.Data;

import java.util.List;

@Data
public class WeekArrangementDto extends BaseModelDto {
    private List<Long> selectedVideoIds;
    private List<Video> videos;
    private DayRange dayRange;
    private List<Long> tagIdList;
    private List<Tag> tags;

    private WeekArrangementDto(Long id, String description, String name, DayRange dayRange, List<Long> tagIdList, List<Long> selectedVideoIds) {
        super(id, name, description);
        this.selectedVideoIds = selectedVideoIds;
        this.dayRange = dayRange;
        this.tagIdList = tagIdList;
    }

    private WeekArrangementDto(Long id, String description, String name, List<Video> videos, DayRange dayRange, List<Tag> tags) {
        super(id, name, description);
        this.videos = videos;
        this.dayRange = dayRange;
        this.tags = tags;
    }


    public static class DtoBuilder{
        private List<Long> selectedVideoIds;
        private DayRange dayRange;
        private List<Long> tagIdList;
        private Long id;
        private String description;
        private String name;
        private List<Video> videos;
        private List<Tag> tags;


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
        public DtoBuilder withSelectedVideoIds(List<Long> selectedVideoIds) {
            this.selectedVideoIds = selectedVideoIds;
            return this;
        } public DtoBuilder withVideos(List<Video> videos) {
            this.videos = videos;
            return this;
        }
        public DtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }
        public DtoBuilder withTagIds(List<Long> tags) {
            this.tagIdList = tags;
            return this;
        }

        public DtoBuilder withTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public WeekArrangementDto build() {
            if ( selectedVideoIds != null ) {
                return new WeekArrangementDto(id, description, name, dayRange, tagIdList, selectedVideoIds);
            } else if ( videos != null ) {
                return new WeekArrangementDto(id, description, name, videos, dayRange, tags);
            }
            return null;
        }





    }
}
