package com.example.videos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "day", indexes = {
        @Index(columnList = "id", name = "day_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "day_id_seq", allocationSize = 1)
@Data
@NoArgsConstructor
public class Day extends BaseModel {
    @Column(name = "date")
    private LocalDate date;

    public Day(LocalDate date) {
        this.date = date;
    }
}
