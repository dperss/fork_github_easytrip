package com.easytrip.easytrip.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends AuditModel {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;
}
