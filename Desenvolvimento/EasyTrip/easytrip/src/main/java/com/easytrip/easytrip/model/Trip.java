package com.easytrip.easytrip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="trips")
public class Trip extends AuditModel{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;
    @Size(min= 0,max = 1000)
   private String Origin;
    @Column(columnDefinition = "text")
   private String Destiny;

   private String Origin_data;


   private String Destiny_data;

   private String Accommodation;

   private String Transportation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Person person;



    public void setId(Long id) {
        this.id = id;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public void setDestiny(String destiny) {
        Destiny = destiny;
    }

    public void setOrigin_data(String origin_data) {
        Origin_data = origin_data;
    }

    public void setDestiny_data(String destiny_data) {
        Destiny_data = destiny_data;
    }

    public void setAccommodation(String accommodation) {
        Accommodation = accommodation;
    }

    public void setTransportation(String transportation) {
        Transportation = transportation;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getDestiny() {
        return Destiny;
    }

    public String getOrigin_data() {
        return Origin_data;
    }

    public String getDestiny_data() {
        return Destiny_data;
    }

    public String getAccommodation() {
        return Accommodation;
    }

    public String getTransportation() {
        return Transportation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



}
