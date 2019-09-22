package com.example.videos.tags;

import com.example.videos.model.BaseModel;
import com.example.videos.model.video.Video;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "video_tag_association", indexes = {
//        @Index(columnList = "id", name = "tag_id_index"),
//        @Index(columnList = "video_id", name = "video_tag_association_video_fk_index"),
//        @Index(columnList = "tag_id", name = "video_tag_association_tag_fk_index")
//})
//@SequenceGenerator(name = "SEQ_STORE", sequenceName = "tag_id_seq", allocationSize = 1)
//@Data
public class VideoTagAssociation extends BaseModel {

//    @ManyToOne
//    @JoinColumn(name = "video_id")
//    private List<Video> videos;
//
//    @ManyToOne
//    @JoinColumn(name = "video_id")
//    private List<Tag> tags;

}
