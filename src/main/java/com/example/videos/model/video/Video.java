package com.example.videos.model.video;

import com.example.videos.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Video extends BaseModel implements VideoSource {

    @Column(name = "name")
    private String name;

    @Column(name = "source")
    private String source;

    public Video(String name, String source) {
        this.name = name;
        this.source = source;
    }

    @Override
    public void setVideSource() {

    }
}
