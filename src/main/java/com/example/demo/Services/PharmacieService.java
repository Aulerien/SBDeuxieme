package com.example.demo.Services;

import com.example.demo.Model.Pharmacie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PharmacieService {

    Pharmacie createPharmacie(Pharmacie pharmacie);
    Pharmacie getPharmacie(Long id);
    Pharmacie editPharmacie(Pharmacie pharmacie);
    void deletePharmacie(Pharmacie pharmacie);
    List<Pharmacie> getAllPharmacie();

}
