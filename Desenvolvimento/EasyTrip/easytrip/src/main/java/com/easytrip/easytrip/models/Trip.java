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
    private Integer id;

    private String Origin;

    private String Destiny;

    private String Origin_date;

    private String Destiny_date;

    private String Accommodation;

    private String Transportation;



    public Trip() {
    }

    public Trip(String origin, String destiny, String origin_date, String destiny_date, String accommodation, String transportation) {
        Origin = origin;
        Destiny = destiny;
        Origin_date = origin_date;
        Destiny_date = destiny_date;
        Accommodation = accommodation;
        Transportation = transportation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAccommodation() {
        return Accommodation;
    }

    public void setAccommodation(String accommodation) {
        Accommodation = accommodation;
    }

    public String getTransportation() {
        return Transportation;
    }

    public void setTransportation(String transportation) {
        Transportation = transportation;
    }
}
