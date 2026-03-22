package com.example.ms_emprunt.mapping;

import com.example.ms_emprunt.dto.EmpruntDTO;
import com.example.ms_emprunt.entities.EmpruntEntity;

public class EmpruntMapper {

    public static EmpruntDTO toDTO(EmpruntEntity entity){

        EmpruntDTO dto = new EmpruntDTO();

        dto.setId(entity.getId());
        dto.setProduitId(entity.getProduitId());
        //dto.setAdherentId(entity.getAdherent().getId());
        dto.setAdherentId(entity.getAdherentId()); // ✅ correction
        dto.setDateEmprunt(entity.getDateEmprunt());
        dto.setDateRetour(entity.getDateRetour());

        return dto;
    }
}