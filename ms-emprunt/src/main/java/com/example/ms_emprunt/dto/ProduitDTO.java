package com.example.ms_emprunt.dto;

import lombok.Data;

@Data
public class ProduitDTO {

    private Long id;
    private String titre;
    private double prix;
    private int stock;
    private String typeProduit;
}