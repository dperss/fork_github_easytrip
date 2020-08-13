package com.easytrip.easytrip.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    private Integer photoContentLength;

    public Image() {
    }

    public Image(byte[] image, Integer photoContentLength) {
        this.image = image;
        this.photoContentLength = photoContentLength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getPhotoContentLength() {
        return photoContentLength;
    }

    public void setPhotoContentLength(Integer photoContentLength) {
        this.photoContentLength = photoContentLength;
    }
}
