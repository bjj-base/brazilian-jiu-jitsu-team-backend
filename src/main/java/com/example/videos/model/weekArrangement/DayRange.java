package com.example.videos.model.weekArrangement;

import com.example.videos.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "day_range", indexes = {
        @Index(columnList = "id", name = "day_range_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "day_range_id_seq", allocationSize = 1)
@Data
@NoArgsConstructor
public class DayRange extends BaseModel implements Serializable {
    @Column(name = "starting_date")
    private LocalDate startDate;

    @Column(name = "ending_date")
    private LocalDate endDate;

    public DayRange(LocalDate starting_date, LocalDate ending_date) {
        this.startDate = starting_date;
        this.endDate = ending_date;
    }
}
