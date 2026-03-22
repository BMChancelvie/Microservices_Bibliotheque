package com.example.ms_emprunt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_emprunt.dto.EmpruntDTO;
import com.example.ms_emprunt.entities.EmpruntEntity;
import com.example.ms_emprunt.service.EmpruntService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/emprunts")
@RequiredArgsConstructor
public class EmpruntController {

    private final EmpruntService empruntService;

    //CREATE
    @PostMapping
    public EmpruntEntity create(@RequestBody EmpruntDTO dto){
        return empruntService.create(dto);
    }
    
    //READ
    @GetMapping
    public List<EmpruntEntity> getAll(){
        return empruntService.getAll();
    }
}