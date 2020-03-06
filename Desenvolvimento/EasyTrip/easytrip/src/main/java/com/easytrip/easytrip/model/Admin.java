package com.easytrip.easytrip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Admin extends Person {


    public Admin(@JsonProperty("id") UUID id,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email){
        super(id, password, email);
    }

    public boolean Delete_admin(){

        return false;
    }
    public boolean Add_user(){
        return false;
    }
    public boolean Freeze_account(){
        return false;
    }
    public boolean Freeze_comment(){
        return false;
    }
    public boolean Freeze_rating(){
        return false;
    }
    public boolean Delete_interest_point(){
        return false;
    }




}
