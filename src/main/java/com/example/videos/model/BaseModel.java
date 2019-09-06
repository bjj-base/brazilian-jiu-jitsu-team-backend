package com.example.videos.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseModel {

    @Id
    @Type(type = "java.lang.Long")
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_STORE")
    protected Long id;

    @CreatedDate
    @Column(name = "inserted_at",  insertable = true, updatable = true)
    protected LocalDateTime insertedAt;

    @LastModifiedDate
    @Column(name = "updated_at",  insertable = true, updatable = true)
    protected LocalDateTime updatedAt;
}
