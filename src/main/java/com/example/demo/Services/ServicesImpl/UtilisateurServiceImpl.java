package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Utilisateur;
import com.example.demo.Repositories.UtilisateurRepository;
import com.example.demo.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.getOne(id);
    }


    @Override
    public Boolean authentifier(String Username, String Password) {
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        for (int i = 0; i < utilisateurList.size(); i++)
        {
            Utilisateur tmp = utilisateurList.get(i);

            if( tmp.getUsername().equals(Username) && tmp.getPassword().equals(Password))
            {
                return true;
            }
        }

        return false;
    }


    @Override
    public Utilisateur getAuthentified(String Username, String Password) {
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        for (int i = 0; i < utilisateurList.size(); i++)
        {
            Utilisateur tmp = utilisateurList.get(i);
            if( tmp.getUsername().equals(Username) && tmp.getPassword().equals(Password))
            {
                return tmp;
            }
        }

        return null;
    }

    @Override
    public Utilisateur editUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }
}
