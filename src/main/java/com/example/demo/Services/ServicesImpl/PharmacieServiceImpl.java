package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Pharmacie;
import com.example.demo.Repositories.PharmacieRepository;
import com.example.demo.Services.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieServiceImpl implements PharmacieService {

    @Autowired
    private PharmacieRepository pharmacieRepository;

    @Override
    public Pharmacie createPharmacie(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie);
    }

    @Override
    public Pharmacie getPharmacie(Long id) {
        return pharmacieRepository.getOne(id);
    }

    @Override
    public Pharmacie editPharmacie(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie);
    }


    @Override
    public void deletePharmacie(Pharmacie pharmacie) {
        pharmacieRepository.delete(pharmacie);
    }


    @Override
    public List<Pharmacie> getAllPharmacie() { return pharmacieRepository.findAll(); }

}
