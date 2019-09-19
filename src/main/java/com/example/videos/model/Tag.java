package com.example.videos.model;

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

    @Column(name = "description")
    private String description;

    public Tag() {
    }
}
