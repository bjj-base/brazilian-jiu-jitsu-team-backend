package com.example.videos.dto;

import com.example.videos.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoDto extends BaseModelDto {

    private String name;
    private String description;
    private String source;
    private String sourceId;
    private Long id;

}
