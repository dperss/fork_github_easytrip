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
    private Long id;




    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "itinerary_point",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "point_of_interest_id"))
    private Set<Point_of_Interest> point_of_interests = new HashSet<>();

    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="comments_fk",referencedColumnName = "id")
    private List<Comment> comments;

    public Itinerary(Set<Point_of_Interest> point_of_interests, List<Comment> comments) {
        this.point_of_interests = point_of_interests;
        this.comments = comments;
    }

    public Itinerary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Point_of_Interest> getPoint_of_interests() {
        return point_of_interests;
    }

    public void setPoint_of_interests(Set<Point_of_Interest> point_of_interests) {
        this.point_of_interests = point_of_interests;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
