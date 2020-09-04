package com.easytrip.easytrip.models;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "point_of_interest")
public class Point_of_Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location_nome;

    private String location_gps;

    private Float classification;

    private String type_of_point;

    @Column(length = 5000)
    private String description;

    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="photos_fk",referencedColumnName = "id")
    private List<Image> images;

    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="comments_fk",referencedColumnName = "id")
    private List<Comment> comments;

    public Point_of_Interest() {
    }

    public Point_of_Interest(String name, String location_nome, String location_gps, Float classification, String type_of_point, String description, List<Image> images, List<Comment> comments) {
        this.name = name;
        this.location_nome = location_nome;
        this.location_gps = location_gps;
        this.classification = classification;
        this.type_of_point = type_of_point;
        this.description = description;
        this.images = images;
        this.comments = comments;
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

    public String getLocation_nome() {
        return location_nome;
    }

    public void setLocation_nome(String location_nome) {
        this.location_nome = location_nome;
    }

    public String getLocation_gps() {
        return location_gps;
    }

    public void setLocation_gps(String location_gps) {
        this.location_gps = location_gps;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
