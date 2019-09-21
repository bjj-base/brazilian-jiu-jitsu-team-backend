package com.example.videos.model.video;

import com.example.videos.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "video", indexes = {
        @Index(columnList = "id", name = "video_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "video_id_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "source", discriminatorType = DiscriminatorType.STRING)
public abstract class Video extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "source", insertable = false, updatable = false)
    private String source;

    public Video(String name) {
        this.name = name;
    }

    public Video() {
    }
}
