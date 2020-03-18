package com.easytrip.easytrip.model;

import javax.persistence.*;

@Entity
@Table(name = "itinerary_points")
public class Itinerary_point extends AuditModel{

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;
}
