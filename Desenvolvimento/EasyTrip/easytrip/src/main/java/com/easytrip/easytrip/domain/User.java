package com.easytrip.easytrip.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;//check securitys hash of srping


    private String nome;


    private String description;


    public User() {
    }

    public User(@NotNull String email, @NotNull String password, String nome, String description) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.description = description;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password){ this.password=password;}

    public String getPassword() {
        return password;
    }

    public void setEmail(String email){this.email=email;}

    public String getEmail() {
        return email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }


}
