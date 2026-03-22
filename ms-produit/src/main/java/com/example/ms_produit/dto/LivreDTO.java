package com.example.ms_produit.dto;

import lombok.Data;

@Data
public class LivreDTO extends ProduitDTO {

    private String auteur;
    private String isbn;
    private int nombrePages;
    private String editeur;
}