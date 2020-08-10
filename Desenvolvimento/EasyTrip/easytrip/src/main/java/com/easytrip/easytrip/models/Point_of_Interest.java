package com.easytrip.easytrip.models;


import javax.persistence.*;

@Entity
@Table(name = "point_of_interest")
public class Point_of_Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String location;

    private Float classification;

    private String type_of_point;

    private String description;


}
