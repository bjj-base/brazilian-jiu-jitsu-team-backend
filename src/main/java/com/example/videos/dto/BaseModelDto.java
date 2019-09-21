package com.example.videos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseModelDto implements Serializable {
    private Long id;

    public BaseModelDto(Long id) {
        this.id = id;
    }
}
