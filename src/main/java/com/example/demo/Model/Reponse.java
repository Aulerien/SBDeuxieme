package com.example.demo.Model;

public class Reponse {

    private Long idUtilisateur;
    private int nbMessage;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getNbMessage() {
        return nbMessage;
    }

    public void setNbMessage(int nbMessage) {
        this.nbMessage = nbMessage;
    }

    public Reponse() {
    }

    public Reponse(Long idUtilisateur, int nbMessage) {
        this.idUtilisateur = idUtilisateur;
        this.nbMessage = nbMessage;
    }
}
