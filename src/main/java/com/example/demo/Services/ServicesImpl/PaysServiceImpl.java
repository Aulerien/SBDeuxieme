package com.example.demo.Services.ServicesImpl;

import com.example.demo.Model.Pays;
import com.example.demo.Repositories.PaysRepository;
import com.example.demo.Services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {



    @Autowired
    private PaysRepository paysRepository;


    @Override
    public Pays createPays(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public Boolean createListPays(List<Pays> pays) {

        try{

            paysRepository.saveAll(pays);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return  false;
    }

    @Override
    public Pays getPays(Long id) {
        return paysRepository.getOne(id);
    }

    @Override
    public Pays editPays(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public void deletePays(Pays pays) {
        paysRepository.delete(pays);
    }

    @Override
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }
}
