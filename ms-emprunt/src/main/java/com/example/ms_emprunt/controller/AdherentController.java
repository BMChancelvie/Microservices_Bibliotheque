package com.example.ms_emprunt.controller;

import com.example.ms_emprunt.entities.AdherentEntity;
import com.example.ms_emprunt.service.AdherentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adherents")
@RequiredArgsConstructor
public class AdherentController {

    private final AdherentService adherentService;

    @PostMapping
    public AdherentEntity create(@RequestBody AdherentEntity adherent){
        return adherentService.create(adherent);
    }

    @GetMapping
    public List<AdherentEntity> getAll(){
        return adherentService.getAll();
    }

    @GetMapping("/{id}")
    public AdherentEntity getById(@PathVariable Long id){
        return adherentService.getById(id);
    }

    @PutMapping("/{id}")
    public AdherentEntity update(@PathVariable Long id,
                                 @RequestBody AdherentEntity adherent){
        return adherentService.update(id, adherent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        adherentService.delete(id);
    }
}