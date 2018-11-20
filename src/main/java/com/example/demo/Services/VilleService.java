package com.example.demo.Services;

import com.example.demo.Model.Ville;

import java.util.List;

public interface VilleService{

    Ville createVille(Ville ville);
    Ville getVille(Long id);
    Ville editVille(Ville ville);
    void deleteVille(Ville ville);
    List<Ville> getAllVille();

}
