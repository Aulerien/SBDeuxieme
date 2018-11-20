package com.example.demo.Repositories;

import com.example.demo.Model.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
}
