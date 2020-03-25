package com.easytrip.easytrip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "itinerary_points")
public class Itinerary_point extends AuditModel{


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itinerary_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Itinerary itinerary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_of_interest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Point_of_interest point_of_interest;

    public Itinerary getItinerary() {
        return itinerary;
    }

    public Point_of_interest getPoint_of_interest() {
        return point_of_interest;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public void setPoint_of_interest(Point_of_interest point_of_interest) {
        this.point_of_interest = point_of_interest;
    }
}
