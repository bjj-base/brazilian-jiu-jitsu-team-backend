package com.example.videos.model.tags;

import com.example.videos.model.BaseModel;
import lombok.Data;

import javax.persistence.*;

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

    @Column(name = "description", columnDefinition = "TEXT", length = 10000)
    private String description;

    public Tag() {
    }

//    @ManyToMany(mappedBy = "tags")
//    private List<Video> videos = new ArrayList<>();
}
