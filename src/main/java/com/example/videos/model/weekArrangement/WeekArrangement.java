package com.example.videos.model.weekArrangement;

import com.example.videos.model.BaseModel;
import com.example.videos.model.video.Video;
import com.example.videos.model.weekArrangement.DayRange;
import com.example.videos.model.tags.Tag;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class WeekArrangement extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", length = 10000)
    private String description;

//    @Type(type = "jsonb")
//    @Column(name = "days")
//    private String selectedDays;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "week_arrangement_tag_association",
            joinColumns = @JoinColumn(name = "week_arrangement_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
//
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "week_arrangement_video_association",
            joinColumns = @JoinColumn(name = "week_arrangement_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private List<Video> videos;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "day_range_id")
    private DayRange dayRange = new DayRange();





}
