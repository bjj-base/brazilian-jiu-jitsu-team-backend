package com.example.videos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "day_range", indexes = {
        @Index(columnList = "id", name = "day_range_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "day_range_id_seq", allocationSize = 1)
@Data
@NoArgsConstructor
public class DayRange extends BaseModel {
    @Column(name = "starting_date")
    private LocalDate starting_date;

    @Column(name = "ending_date")
    private LocalDate ending_date;

    public DayRange(LocalDate starting_date, LocalDate ending_date) {
        this.starting_date = starting_date;
        this.ending_date = ending_date;
    }
}
