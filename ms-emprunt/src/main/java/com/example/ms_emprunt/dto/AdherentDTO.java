package com.example.ms_emprunt.dto;

import lombok.Data;

@Data
public class AdherentDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    // On rajoute id obtenu dans le microservice ms-personnel
    private String numeroAdherent;
}