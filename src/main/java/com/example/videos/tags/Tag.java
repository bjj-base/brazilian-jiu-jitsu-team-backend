package com.example.videos.tags;

import com.example.videos.model.BaseModel;
import com.example.videos.model.video.Video;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag", indexes = {
        @Index(columnList = "id", name = "tag_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "tag_id_seq", allocationSize = 1)
@Data
public class Tag extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    public Tag() {
    }

//    @ManyToMany(mappedBy = "tags")
//    private List<Video> videos = new ArrayList<>();
}
