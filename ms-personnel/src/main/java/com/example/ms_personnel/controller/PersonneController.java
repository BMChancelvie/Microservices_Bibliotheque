package com.example.ms_personnel.controller;

import com.example.ms_personnel.dto.PersonneDTO;
import com.example.ms_personnel.entities.*;
import com.example.ms_personnel.mapping.PersonneMapper;
import com.example.ms_personnel.repository.PersonneRepository;
//import com.example.ms_personnel.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
@RequiredArgsConstructor
public class PersonneController {

    private final PersonneRepository personneRepository;
    //private final ServiceRepository serviceRepository;
    //private final PersonneMapper mapper;

    // CREATE
    @PostMapping
    public PersonneDTO create(@RequestBody PersonneDTO dto){

        if(dto.getTypePersonne() == null){
            throw new RuntimeException("typePersonne obligatoire");
        }

        PersonneEntity entity;

        switch (dto.getTypePersonne()) {

            case "ADHERENT" -> {
                AdherentEntity a = new AdherentEntity();
                a.setNumeroAdherent(dto.getNumeroAdherent());
                entity = a;
            }

            case "EMPLOYE" -> {
                EmployeEntity e = new EmployeEntity();
                e.setPoste(dto.getPoste());
                entity = e;
            }

            case "RESPONSABLE" -> {
                ResponsableEntity r = new ResponsableEntity();
                r.setPoste(dto.getPoste());
                r.setNiveauResponsabilite(dto.getNiveauResponsabilite());
                entity = r;
            }

            default -> throw new RuntimeException("Type invalide");
        }

        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());

        return PersonneMapper.toDTO(personneRepository.save(entity));
    }

    // READ ALL
    @GetMapping
    public List<PersonneDTO> getAll(){
        return personneRepository.findAll()
                .stream()
                .map(PersonneMapper::toDTO)
                .toList();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public PersonneDTO getById(@PathVariable Long id){
        PersonneEntity entity = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne introuvable"));

        return PersonneMapper.toDTO(entity);
    }

    // UPDATE
    @PutMapping("/{id}")
    public PersonneDTO update(@PathVariable Long id,
                              @RequestBody PersonneDTO dto){

        PersonneEntity entity = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne introuvable"));

        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());

        return PersonneMapper.toDTO(personneRepository.save(entity));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personneRepository.deleteById(id);
    }
}