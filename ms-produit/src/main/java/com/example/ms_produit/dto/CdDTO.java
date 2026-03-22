package com.example.ms_produit.dto;

import lombok.Data;

@Data
public class CdDTO extends ProduitDTO {

    private String artiste;
    private String genre;
    private int nombrePistes;
}