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

    public Accommodation() {
    }

    public Accommodation(String name, String location, String description, String price, Float rating, List<Image> images) {
        this.name = name;
        Location = location;
        Description = description;
        Price = price;
        Rating = rating;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Image> getPhotos() {
        return images;
    }

    public void setPhotos(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
