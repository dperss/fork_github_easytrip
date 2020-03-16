package com.easytrip.easytrip.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

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
    private String email;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;*/

    public Person(){
        this.id = id;
        this.password = password;
        this.email = email;
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


}
