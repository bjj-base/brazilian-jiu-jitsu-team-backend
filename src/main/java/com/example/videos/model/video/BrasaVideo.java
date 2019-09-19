package com.example.videos.model.video;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brasa_video", indexes = {
        @Index(columnList = "id", name = "brasa_video_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "brasa_video_id_seq", allocationSize = 1)
@Data
public class BrasaVideo extends Video {

    public BrasaVideo() {}

    public BrasaVideo(String name) {
        super(name, Source.BRASA_HELLAS.toString());
    }


    @Override
    public void setVideSource() {
        this.setSource(Source.BRASA_HELLAS.toString());
    }
}
