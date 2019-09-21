package com.example.videos.model.video;

import lombok.Data;

import javax.persistence.*;


@Data
@DiscriminatorValue(value = "YOUTUBE")
@Entity
public class YoutubeVideo extends Video {

    @Column(name = "source_id")
    private String sourceId;

    public YoutubeVideo() {}

    public YoutubeVideo(String name, String sourceId) {
        super(name);
        this.sourceId = sourceId;
    }



}
