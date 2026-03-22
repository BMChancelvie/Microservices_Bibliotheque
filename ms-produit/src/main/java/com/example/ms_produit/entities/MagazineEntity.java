package com.example.ms_produit.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MAGAZINE")
public class MagazineEntity extends ProduitEntity {

    private int numero;
    private String periodicite;
    private String editeur;
}