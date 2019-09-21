package com.example.videos.model.video;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@DiscriminatorValue(value = "BRASA_HELLAS")
public class BrasaVideo extends Video {

    public BrasaVideo() {}

    public BrasaVideo(String name) {
        super(name);
    }
}
