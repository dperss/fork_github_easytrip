package com.easytrip.easytrip.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "itinerarys")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    @ManyToMany
    @JoinTable(name = "itinerary_point",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "point_of_interest_id"))
    private Set<Role> points = new HashSet<>();



}
