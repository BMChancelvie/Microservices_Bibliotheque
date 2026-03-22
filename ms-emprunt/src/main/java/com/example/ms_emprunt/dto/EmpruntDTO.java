package com.example.ms_emprunt.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpruntDTO {

    private Long id;
    private Long produitId;
    private Long adherentId;
    private String nomAdherent;
    private String emailAdherent;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
}