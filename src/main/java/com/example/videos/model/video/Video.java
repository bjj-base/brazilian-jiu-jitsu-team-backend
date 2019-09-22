package com.example.videos.model.video;

import com.example.videos.dto.VideoDto;
import com.example.videos.model.BaseModel;
import com.example.videos.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "video", indexes = {
        @Index(columnList = "id", name = "video_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "video_id_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "source", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public abstract class Video extends BaseModel implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "source", insertable = false, updatable = false)
    private String source;

    public Video(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.ALL,
            })
    @JoinTable(name = "video_tag",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")

    )
    private List<Tag> tags = new ArrayList<>();

    public VideoDto toDto() {
        VideoDto dto = new VideoDto();
        return dto;
    }
}
