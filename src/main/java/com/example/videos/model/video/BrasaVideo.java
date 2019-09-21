package com.example.videos.model.video;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@DiscriminatorValue(value = "BRASA_HELLAS")
public class BrasaVideo extends Video {

    public BrasaVideo() {}

    @Column(name = "uuid")
    private String uuid;

    public BrasaVideo(String uuid, String name) {
        super(name);
        this.uuid = uuid;
    }
}
