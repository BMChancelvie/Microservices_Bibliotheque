package com.example.ms_emprunt.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="emprunts")
public class EmpruntEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produitId;

    private LocalDate dateEmprunt;

    private LocalDate dateRetour;

    /*@ManyToOne
    @JoinColumn(name="adherent_id")
    private AdherentEntity adherent;*/
    
    private Long adherentId; // ✅ IMPORTANT
}