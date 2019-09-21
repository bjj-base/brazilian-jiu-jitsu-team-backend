package com.example.videos.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    public BaseModel() {}

    @Id
    @Type(type = "java.lang.Long")
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_STORE")
    protected Long id;


    @CreationTimestamp
    @Column(name = "inserted_at",  insertable = true, updatable = true)
    protected LocalDateTime insertedAt;

    @UpdateTimestamp
    @Column(name = "updated_at",  insertable = true, updatable = true)
    protected LocalDateTime updatedAt;
}
