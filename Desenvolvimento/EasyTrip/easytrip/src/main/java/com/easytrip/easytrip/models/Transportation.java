package com.easytrip.easytrip.models;

import javax.persistence.*;

@Entity
@Table(name = "transportations")
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Type;

    private String Description;

    private String Price;

    private float Rating;

    public Transportation() {
    }

    public Transportation(String type, String description, String price, float rating) {
        Type = type;
        Description = description;
        Price = price;
        Rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }
}
