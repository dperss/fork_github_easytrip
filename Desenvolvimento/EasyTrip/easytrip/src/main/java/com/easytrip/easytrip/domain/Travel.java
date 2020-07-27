package com.easytrip.easytrip.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Travel {

    @Id
    @GeneratedValue
    private Long id;

    private String Origin;

    private String Destiny;

    private String Origin_date;

    private String Destiny_date;

    private String Accommodation;

    private String Transportation;

    public Travel() {
    }

    public Travel(String origin, String destiny, String origin_date, String destiny_date, String accommodation, String transportation) {
        Origin = origin;
        Destiny = destiny;
        Origin_date = origin_date;
        Destiny_date = destiny_date;
        Accommodation = accommodation;
        Transportation = transportation;
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
