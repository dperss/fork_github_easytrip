package com.easytrip.easytrip.models;

import com.easytrip.easytrip.security.services.UserDetailsImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@ApiModel(description = "Details about the users")
public class User {


    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The unique id of the Users")
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private String description;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_points",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "point_of_interest_id"))
    private Set<Point_of_Interest> user_points = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_trips",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private Set<Trip> trips = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_id", referencedColumnName = "id")
    private Image images;


    public User() {
    }

    public User(@NotBlank @Size(max = 20) String username,  @NotBlank String email,@NotBlank String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles=roles;
    }

    public Set<Point_of_Interest> getUser_points() {
        return user_points;
    }

    public void setUser_points(Set<Point_of_Interest> user_points) {
        this.user_points = user_points;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }
}



