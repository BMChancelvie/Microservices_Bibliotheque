package com.example.ms_produit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ms_produit.entities.ProduitEntity;
import com.example.ms_produit.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitService {

 private final ProduitRepository produitRepository;

 public ProduitEntity create(ProduitEntity produit){
  return produitRepository.save(produit);
 }

 public List<ProduitEntity> findAll(){
  return produitRepository.findAll();
 }

 public ProduitEntity findById(Long id){
  return produitRepository.findById(id)
   .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
 }

 public ProduitEntity update(Long id, ProduitEntity produit){

  ProduitEntity p = findById(id);

  p.setTitre(produit.getTitre());
  p.setPrix(produit.getPrix());
  p.setStock(produit.getStock());

  return produitRepository.save(p);
 }

 public void delete(Long id){
  produitRepository.deleteById(id);
 }
}

