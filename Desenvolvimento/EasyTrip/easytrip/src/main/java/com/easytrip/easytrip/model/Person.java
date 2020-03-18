package com.easytrip.easytrip.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persons")
public class Person extends AuditModel {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min= 4,max = 1000)
    private String password;//check securitys hash of srping

    @NotBlank
    @Column(unique = true)
    private String email;

    @Size(min= 0,max = 1000)
    private String nome;

    @Column(columnDefinition="VARCHAR(100)")
    private String description;

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
