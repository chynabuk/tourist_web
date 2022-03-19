package org.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tours")
@Getter
@Setter
@NoArgsConstructor
public class Tour {
    @Id
    private Integer tourNumber;

    @ManyToOne
    @JoinColumn(name = "tour_type_id")
    private TourType tourType;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ManyToOne
    private Program program;

    @Column
    private String name;

    @Column
    private String status;
}
