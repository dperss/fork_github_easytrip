package com.easytrip.easytrip.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Origin;

    private String Destiny;

    private String Origin_date;

    private String Destiny_date;


    @ManyToMany
    @JoinTable(name = "trip_accomodations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "accommodations_id"))
    private Set<Accommodation> accommodations = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_transports",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "transportation_id"))
    private Set<Transportation> transportation = new HashSet<>();


    @OneToMany(targetEntity = Itinerary.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="itineraries_fk",referencedColumnName = "id")
    private List<Itinerary> itineraries;


    public Trip() {
    }

    public Trip(String origin, String destiny, String origin_date, String destiny_date, Set<Accommodation> accommodations, Set<Transportation> transportation, List<Itinerary> itineraries) {
        Origin = origin;
        Destiny = destiny;
        Origin_date = origin_date;
        Destiny_date = destiny_date;
        this.accommodations = accommodations;
        this.transportation = transportation;
        this.itineraries = itineraries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestiny() {
        return Destiny;
    }

    public void setDestiny(String destiny) {
        Destiny = destiny;
    }

    public String getOrigin_date() {
        return Origin_date;
    }

    public void setOrigin_date(String origin_date) {
        Origin_date = origin_date;
    }

    public String getDestiny_date() {
        return Destiny_date;
    }

    public void setDestiny_date(String destiny_date) {
        Destiny_date = destiny_date;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public Set<Transportation> getTransportation() {
        return transportation;
    }

    public void setTransportation(Set<Transportation> transportation) {
        this.transportation = transportation;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }
}
