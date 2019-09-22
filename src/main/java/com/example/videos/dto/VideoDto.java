package com.example.videos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class VideoDto extends BaseModelDto {

    private String name;
    private String description;
    private String source;
    private String sourceId;
    private List<Long> tagIdList;

    public VideoDto(Long id, String name, String description, String source, String sourceId, List<Long> tagIdList) {
        super(id);
        this.name = name;
        this.description = description;
        this.source = source;
        this.sourceId = sourceId;
        this.tagIdList = tagIdList;
    }

    public static class DtoBuilder {
        private String name;
        private String description;
        private String source;
        private String sourceId;
        private Long id;
        private List<Long> tagIdList;

        public DtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DtoBuilder withSource(String source) {
            this.source = source;
            return this;
        }
        public DtoBuilder withSourceId(String sourceId) {
            this.sourceId = sourceId;
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



        public VideoDto build() {
            return new VideoDto( id, name, description, source, sourceId, tagIdList);
        }
    }



}
