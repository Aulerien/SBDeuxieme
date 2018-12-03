package com.example.demo.Services;


import com.example.demo.Model.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    Utilisateur createUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateur(Long id);
    Boolean authentifier(String Username, String Password);
    Utilisateur getAuthentified(String Username, String Password);
    Utilisateur editUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> getAllUtilisateur();
    
}
