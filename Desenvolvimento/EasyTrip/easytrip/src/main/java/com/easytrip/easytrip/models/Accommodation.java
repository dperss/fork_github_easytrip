package com.easytrip.easytrip.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String Location;

    private String Description;

    private String Price;

    private Float Rating;

    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="photos_fk",referencedColumnName = "id")
    private List<Image> images;

    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="comments_fk",referencedColumnName = "id")
    private List<Comment> comments;

    public Accommodation() {
    }

    public Accommodation(String name, String location, String description, String price, Float rating, List<Image> images, List<Comment> comments) {
        this.name = name;
        Location = location;
        Description = description;
        Price = price;
        Rating = rating;
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
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
