package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Ville;
import com.example.demo.Repositories.VilleRepository;
import com.example.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements VilleService {

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville createVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public Ville getVille(Long id) {
        return villeRepository.getOne(id);
    }

    @Override
    public Ville editVille(Ville ville) {

        return villeRepository.save(ville);
    }


    @Override
    public void deleteVille(Ville ville) {
        villeRepository.delete(ville);
    }


    @Override
    public List<Ville> getAllVille() {

        return villeRepository.findAll();
    }
}
