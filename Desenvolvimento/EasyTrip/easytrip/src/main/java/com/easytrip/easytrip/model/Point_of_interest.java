package com.easytrip.easytrip.model;

import javax.persistence.*;

@Entity
@Table(name = "point_of_interests")
public class Point_of_interest extends AuditModel{

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;
}
