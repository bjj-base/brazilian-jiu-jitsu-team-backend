package com.example.videos.model.video;

import com.example.videos.model.BaseModel;
import com.example.videos.model.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "week_arrangement", indexes = {
        @Index(columnList = "id", name = "week_arrangement_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "week_arrangement_id_seq", allocationSize = 1)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class WeekArrangement extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;



    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "week_arrangement_tag_association",
            joinColumns = @JoinColumn(name = "week_arrangement_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
//
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "week_arrangement_video_association",
            joinColumns = @JoinColumn(name = "week_arrangement_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private Set<Video> videos;

}
