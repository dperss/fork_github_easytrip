package com.easytrip.easytrip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private UUID id;
    private final String password;//check securitys hash of srping
    private final String email;

    public Person(
        @JsonProperty("id") UUID id,
        @JsonProperty("password") String password,
        @JsonProperty("email") String email){
        this.id = id;
        this.password = password;
        this.email = email;
    }
    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


}
