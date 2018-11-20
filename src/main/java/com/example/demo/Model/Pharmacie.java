package com.example.demo.Model;


import javax.persistence.*;

@Entity
@Table(name = "Pharmacie")
public class Pharmacie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pharmacie_id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private  String adresse;

    @Column(name = "telephone")
    private String telephone;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ville_id")
    private Ville ville;


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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }


    public Pharmacie(String nom, String adresse, String telephone, Ville ville) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.ville = ville;
    }


    public Pharmacie() {}



    @Override
    public String toString() {
        return "Pharmacie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", ville=" + ville +
                '}';
    }
}

