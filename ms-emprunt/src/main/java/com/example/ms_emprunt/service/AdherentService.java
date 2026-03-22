package com.example.ms_emprunt.service;

import com.example.ms_emprunt.entities.AdherentEntity;
import com.example.ms_emprunt.repository.AdherentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdherentService {

    private final AdherentRepository adherentRepository;

    public AdherentEntity create(AdherentEntity adherent){
        return adherentRepository.save(adherent);
    }

    public List<AdherentEntity> getAll(){
        return adherentRepository.findAll();
    }

    public AdherentEntity getById(Long id){
        return adherentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adherent introuvable"));
    }

    public AdherentEntity update(Long id, AdherentEntity adherent){

        AdherentEntity a = getById(id);

        a.setNom(adherent.getNom());
        a.setPrenom(adherent.getPrenom());
        a.setEmail(adherent.getEmail());

        return adherentRepository.save(a);
    }

    public void delete(Long id){
        adherentRepository.deleteById(id);
    }
}