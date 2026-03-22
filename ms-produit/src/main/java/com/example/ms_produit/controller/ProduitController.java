package com.example.ms_produit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_produit.entities.ProduitEntity;
import com.example.ms_produit.service.ProduitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {

 private final ProduitService produitService;

 @PostMapping
 public ProduitEntity create(@RequestBody ProduitEntity produit){
  return produitService.create(produit);
 }

 @GetMapping
 public List<ProduitEntity> getAll(){
  return produitService.findAll();
 }

 @GetMapping("/{id}")
 public ProduitEntity getById(@PathVariable Long id){
  return produitService.findById(id);
 }

 @PutMapping("/{id}")
 public ProduitEntity update(@PathVariable Long id,@RequestBody ProduitEntity produit){
  return produitService.update(id, produit);
 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Long id){
  produitService.delete(id);
 }
}