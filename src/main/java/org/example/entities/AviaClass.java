package org.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.AviaClassEnum;

import javax.persistence.*;

@Entity
@Table(name = "avia_classes")
@Getter
@Setter
@NoArgsConstructor
public class AviaClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private AviaClassEnum aviaClassEnum;
}
