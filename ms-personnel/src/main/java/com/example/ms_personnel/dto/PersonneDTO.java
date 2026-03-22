package com.example.ms_personnel.dto;

import lombok.Data;

@Data
public class PersonneDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String typePersonne;
    
    // spécifiques
    private String numeroAdherent;
    private String poste;
    private String niveauResponsabilite;
    private Long serviceId;
}