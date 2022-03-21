package org.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "tour_tasks")
@Getter
@Setter
@NoArgsConstructor
public class TourTask {
    @Id
    Integer taskNumber;

    @ManyToOne
    @JoinColumn(name = "employee_passport_number")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "tour_number")
    private Tour tour;

    @Column
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column
    private String status;
}
