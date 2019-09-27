package com.example.videos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseModelDto implements Serializable {
    private Long id;
    private String description;
    private String name;

    public BaseModelDto(Long id) {
        this.id = id;
    }

    public BaseModelDto(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }
}
