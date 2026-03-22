package com.example.ms_emprunt.service;

import org.springframework.stereotype.Service;

import com.example.ms_emprunt.dto.AdherentDTO;
import com.example.ms_emprunt.dto.EmpruntDTO;
import com.example.ms_emprunt.dto.ProduitDTO;
import com.example.ms_emprunt.client.AdherentClient;
import com.example.ms_emprunt.client.ProduitClient;
//import com.example.ms_emprunt.entities.AdherentEntity;
import com.example.ms_emprunt.entities.EmpruntEntity;
//import com.example.ms_emprunt.mapping.EmpruntMapper;
//import com.example.ms_emprunt.repository.AdherentRepository;
import com.example.ms_emprunt.repository.EmpruntRepository;
import com.example.ms_personnel.dto.PersonneDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final AdherentClient adherentClient;
    private final ProduitClient produitClient;

    // CREATE
    public EmpruntEntity create(EmpruntDTO dto){

        // Appel du microservice ms-personnel sur l'objet Adherant
        PersonneDTO adherent;
        try {
            adherent = adherentClient.getAdherentById(dto.getAdherentId());
        } catch (Exception e) {
            throw new RuntimeException("Adhérent introuvable");
        }

        // Appel du microservice ms-produit sur l'objet Produit
        ProduitDTO produit;
        try {
            produit = produitClient.getProduitById(dto.getProduitId());
        } catch (Exception e) {
            throw new RuntimeException("Produit introuvable");
        }

        // Vérification stock
        if(produit.getStock() <= 0){
            throw new RuntimeException("Produit non disponible (stock épuisé)");
        }

        // Création emprunt
        EmpruntEntity emprunt = new EmpruntEntity();

        emprunt.setProduitId(produit.getId());
        emprunt.setAdherentId(adherent.getId());
        emprunt.setDateEmprunt(dto.getDateEmprunt());
        emprunt.setDateRetour(dto.getDateRetour());

        return empruntRepository.save(emprunt);
    }

    // READ ALL
    public List<EmpruntEntity> getAll(){
        return empruntRepository.findAll();
    }

    // READ BY ID
    public EmpruntEntity getById(Long id){
        return empruntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprunt introuvable"));
    }

    // DELETE
    public void delete(Long id){
        if(!empruntRepository.existsById(id)){
            throw new RuntimeException("Emprunt introuvable");
        }
        empruntRepository.deleteById(id);
    }
}