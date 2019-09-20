package com.example.videos.repository;

import com.example.videos.model.video.BrasaVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrasaVideoRepository extends AbstractRepository<BrasaVideo> {
}
