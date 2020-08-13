package com.easytrip.easytrip.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "point_of_interest")
public class Point_of_Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private Float classification;

    private String type_of_point;

    private String description;

    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="photos_fk",referencedColumnName = "id")
    private List<Image> images;

    public Point_of_Interest() {
    }

    public Point_of_Interest(String name, String location, Float classification, String type_of_point, String description, List<Image> images) {
        this.name = name;
        this.location = location;
        this.classification = classification;
        this.type_of_point = type_of_point;
        this.description = description;
        this.images = images;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public List<Image> getPhotos() {
        return images;
    }

    public void setPhotos(List<Image> images) {
        this.images = images;
    }
}
