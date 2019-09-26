package com.example.videos.repository;

import com.example.videos.model.tags.Tag;
import com.example.videos.model.video.Video;

import java.util.List;

public interface VideoRepository <T extends Video> extends AbstractRepository<T> {
    @Override
    List<T> findAllById(Iterable<Long> ids);
}
