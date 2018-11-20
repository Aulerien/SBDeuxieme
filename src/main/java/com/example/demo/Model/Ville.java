package com.example.demo.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ville")
public class Ville {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ville_id")
    private Long id;

    @Column(name = "nom")
    private  String nom;


    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pharmacie> pharmacies;


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

    public Set<Pharmacie> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Set<Pharmacie> pharmacies) {
        this.pharmacies = pharmacies;
    }


    public Ville(String nom, Set<Pharmacie> pharmacies) {
        this.nom = nom;
        this.pharmacies = pharmacies;
    }


    public Ville(){}


    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pharmacies=" + pharmacies +
                '}';
    }
}


