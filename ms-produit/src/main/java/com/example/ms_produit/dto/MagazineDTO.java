package com.example.ms_produit.dto;

import lombok.Data;

@Data
public class MagazineDTO extends ProduitDTO {

    private int numero;
    private String periodicite;
    private String editeur;
}