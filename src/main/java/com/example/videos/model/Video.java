package com.example.videos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "video", indexes = {
        @Index(columnList = "id", name = "video_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "video_id_seq", allocationSize = 1)
@Data
public class Video extends BaseModel {
    @Column(name = "name")
    private String name;

    public Video() {}

    public Video(String name) {
        this.name = name;
    }
}
