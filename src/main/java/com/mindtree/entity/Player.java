package com.mindtree.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "covid_data")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String state;

    private String district;

    @Column(name = "date")
    private LocalDate localDate;

    private String tested;

    private String confirmed;

    private String recovered;
}
