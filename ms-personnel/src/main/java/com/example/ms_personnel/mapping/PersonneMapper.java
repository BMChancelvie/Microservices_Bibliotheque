package com.example.ms_personnel.mapping;

import com.example.ms_personnel.dto.AdherentDTO;
import com.example.ms_personnel.dto.EmployeDTO;
import com.example.ms_personnel.dto.PersonneDTO;
import com.example.ms_personnel.dto.ResponsableDTO;
import com.example.ms_personnel.entities.AdherentEntity;
import com.example.ms_personnel.entities.EmployeEntity;
import com.example.ms_personnel.entities.PersonneEntity;
import com.example.ms_personnel.entities.ResponsableEntity;

public class PersonneMapper {

    public static PersonneDTO toDTO(PersonneEntity entity){

        if(entity instanceof ResponsableEntity r){
            ResponsableDTO dto = new ResponsableDTO();
            dto.setId(r.getId());
            dto.setNom(r.getNom());
            dto.setPrenom(r.getPrenom());
            dto.setEmail(r.getEmail());
            dto.setTypePersonne("RESPONSABLE");
            dto.setPoste(r.getPoste());
            dto.setNiveauResponsabilite(r.getNiveauResponsabilite());
            return dto;
        }

        if(entity instanceof EmployeEntity e){
            EmployeDTO dto = new EmployeDTO();
            dto.setId(e.getId());
            dto.setNom(e.getNom());
            dto.setPrenom(e.getPrenom());
            dto.setEmail(e.getEmail());
            dto.setTypePersonne("EMPLOYE");
            dto.setPoste(e.getPoste());
            if(e.getService()!=null)
                dto.setServiceId(e.getService().getId());
            return dto;
        }

        if(entity instanceof AdherentEntity a){
            AdherentDTO dto = new AdherentDTO();
            dto.setId(a.getId());
            dto.setNom(a.getNom());
            dto.setPrenom(a.getPrenom());
            dto.setEmail(a.getEmail());
            dto.setTypePersonne("ADHERENT");
            dto.setNumeroAdherent(a.getNumeroAdherent());
            return dto;
        }

        return null;
    }
}