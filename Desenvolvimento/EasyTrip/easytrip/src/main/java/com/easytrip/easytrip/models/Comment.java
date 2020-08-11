package com.easytrip.easytrip.models;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private float classification;

    public Comment(String comment, float classification) {
        this.comment = comment;
        this.classification = classification;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getClassification() {
        return classification;
    }

    public void setClassification(float classification) {
        this.classification = classification;
    }
}
