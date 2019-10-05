package com.example.videos.repository;

import com.example.videos.model.BaseModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T extends BaseModel> extends CrudRepository<T, Long> {

    @Override
    List<T> findAll();

    List<T> findAll(Sort sort);

//    @Override
//    Iterable<T> findAllById(Iterable<Long> ids);




}
