package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private  String lien;

    public Pays() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }



    public String getSanteLien(){
      return   "https://newsapi.org/v2/top-headlines?country="+getLien()+"&category=health&apiKey=114e65a33b32454ebac50089cc41b73c";
    }


    public String getDivertissementLien(){
      return   "https://newsapi.org/v2/top-headlines?country="+getLien()+"&category=entertainment&apiKey=114e65a33b32454ebac50089cc41b73c";
    }


    public String getAffaireLien(){
      return   "https://newsapi.org/v2/top-headlines?country="+getLien()+"&category=business&apiKey=114e65a33b32454ebac50089cc41b73c";
    }


    public String getSportLien(){
      return   "https://newsapi.org/v2/top-headlines?country="+getLien()+"&category=sports&apiKey=114e65a33b32454ebac50089cc41b73c";
    }


    public String getTechnologiLien(){
      return   "https://newsapi.org/v2/top-headlines?country="+getLien()+"&category=technology&apiKey=114e65a33b32454ebac50089cc41b73c";
    }

}
