package com.example.videos.repository;

import com.example.videos.model.video.Video;

public interface VideoRepository <T extends Video> extends AbstractRepository<T> {
}
