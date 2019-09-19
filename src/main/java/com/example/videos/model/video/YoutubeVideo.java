package com.example.videos.model.video;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "youtube_video", indexes = {
        @Index(columnList = "id", name = "youtube_video_id_index"),
        @Index(columnList = "source_id", name = "youtube_video_source_id_index", unique = true)
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "youtube_video_id_seq", allocationSize = 1)
@Data
public class YoutubeVideo extends Video {

    @Column(name = "source_id", unique = true)
    private String sourceId;

    public YoutubeVideo() {}

    public YoutubeVideo(String name, String sourceId) {
        super(name, Source.YOUTUBE.toString());
        this.sourceId = sourceId;
    }


    @Override
    public void setVideSource() {
        this.setSource(Source.YOUTUBE.toString());
    }
}
