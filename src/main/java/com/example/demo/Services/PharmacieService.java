package com.example.demo.Services;

import com.example.demo.Model.Pharmacie;

import java.util.List;

public interface PharmacieService {

    Pharmacie createPharmacie(Pharmacie pharmacie);
    Pharmacie getPharmacie(Long id);
    Pharmacie editPharmacie(Pharmacie pharmacie);
    void deletePharmacie(Pharmacie pharmacie);
    List<Pharmacie> getAllPharmacie();

}
