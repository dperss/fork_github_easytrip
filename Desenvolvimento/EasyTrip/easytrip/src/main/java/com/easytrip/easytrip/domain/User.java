package com.easytrip.easytrip.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Schema(
            description = "User unique identifier id",
            example = "1",
            required = true
    )
    @Id
    @GeneratedValue
    private Long id;

    @Schema(
            description = "Email",
            example = "Test@test.com"
    )
    @NotNull
    private String email;

    @Schema(
            description = "Password",
            example = "test"
    )
    @NotNull
    private String password;//check securitys hash of srping

    @Schema(
            description = "Email",
            example = "Test@test.com"
    )
    private String nome;

    @Schema(
            description = "Email",
            example = "Test@test.com"
    )
    private String description;

    private String photo;


    public User() {
    }

    public User(@NotNull String email, @NotNull String password, String nome, String description,String photo) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.description = description;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
