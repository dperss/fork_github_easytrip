package com.easytrip.easytrip.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Column(name = "picByte", length = 1000)
    private byte[] image;

    public Image(String name, String type, byte[] image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public Image() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
