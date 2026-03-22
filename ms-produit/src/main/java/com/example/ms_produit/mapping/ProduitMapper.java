package com.example.ms_produit.mapping;

import com.example.ms_produit.dto.*;
import com.example.ms_produit.entities.*;

import lombok.Data;

@Data

public class ProduitMapper {

    public static ProduitDTO toDTO(ProduitEntity entity){

        if(entity instanceof LivreEntity livre){
            LivreDTO dto = new LivreDTO();
            dto.setId(livre.getId());
            dto.setTitre(livre.getTitre());
            dto.setPrix(livre.getPrix());
            dto.setStock(livre.getStock());
            dto.setTypeProduit("LIVRE");

            dto.setAuteur(livre.getAuteur());
            dto.setIsbn(livre.getIsbn());
            dto.setNombrePages(livre.getNombrePages());
            dto.setEditeur(livre.getEditeur());

            return dto;
        }

        if(entity instanceof CdEntity cd){
            CdDTO dto = new CdDTO();
            dto.setId(cd.getId());
            dto.setTitre(cd.getTitre());
            dto.setPrix(cd.getPrix());
            dto.setStock(cd.getStock());
            dto.setTypeProduit("CD");

            dto.setArtiste(cd.getArtiste());
            dto.setGenre(cd.getGenre());
            dto.setNombrePistes(cd.getNombrePistes());

            return dto;
        }

        if(entity instanceof MagazineEntity magazine){
            MagazineDTO dto = new MagazineDTO();
            dto.setId(magazine.getId());
            dto.setTitre(magazine.getTitre());
            dto.setPrix(magazine.getPrix());
            dto.setStock(magazine.getStock());
            dto.setTypeProduit("MAGAZINE");

            dto.setNumero(magazine.getNumero());
            dto.setPeriodicite(magazine.getPeriodicite());
            dto.setEditeur(magazine.getEditeur());

            return dto;
        }

        return null;
    }
}