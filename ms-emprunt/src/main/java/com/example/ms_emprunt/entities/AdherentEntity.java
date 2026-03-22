package com.example.ms_emprunt.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="adherents")
public class AdherentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
}