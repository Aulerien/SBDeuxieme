package com.example.demo.Services;

import com.example.demo.Model.Pays;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaysService {

    Pays createPays(Pays pays);
    Boolean createListPays(List<Pays> pays);
    Pays getPays(Long id);
    Pays editPays(Pays pays);
    void deletePays(Pays pays);
    List<Pays> getAllPays();
}
