package com.easytrip.easytrip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "itinerary")
public class Itinerary extends AuditModel {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    private int classification;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Trip trip;

    public Long getId() {
        return id;
    }

    public int getClassification() {
        return classification;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
