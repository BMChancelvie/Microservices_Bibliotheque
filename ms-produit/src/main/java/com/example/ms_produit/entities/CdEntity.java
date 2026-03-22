package com.example.ms_produit.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("CD")
public class CdEntity extends ProduitEntity {

    private String artiste;
    private String genre;
    private int nombrePistes;
}