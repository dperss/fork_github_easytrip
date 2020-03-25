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

    private String name;

    private String GPS;//Change later to a better data scututre

    private Float classification;

    private String type_of_point;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public Float getClassification() {
        return classification;
    }

    public void setClassification(Float classification) {
        this.classification = classification;
    }

    public String getType_of_point() {
        return type_of_point;
    }

    public void setType_of_point(String type_of_point) {
        this.type_of_point = type_of_point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
