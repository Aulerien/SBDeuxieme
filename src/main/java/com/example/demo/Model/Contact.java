package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    private String nom;
    private String email;


    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}


