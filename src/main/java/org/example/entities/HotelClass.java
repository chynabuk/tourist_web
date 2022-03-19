package org.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.HotelClassEnum;

import javax.persistence.*;

@Entity
@Table(name = "hotel_class")
@Getter
@Setter
@NoArgsConstructor
public class HotelClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private HotelClassEnum hotelClassEnum;
}
