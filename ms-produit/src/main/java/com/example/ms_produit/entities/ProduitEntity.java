package com.example.ms_produit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="produits")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_produit")
public class ProduitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private double prix;
    private int stock;
}