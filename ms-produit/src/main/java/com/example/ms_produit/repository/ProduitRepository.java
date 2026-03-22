package com.example.ms_produit.repository;

import com.example.ms_produit.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {
}