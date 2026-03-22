package com.example.ms_produit.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("LIVRE")
public class LivreEntity extends ProduitEntity {
	
    private String auteur;
    private String isbn;
    private int nombrePages;
    private String editeur;
}