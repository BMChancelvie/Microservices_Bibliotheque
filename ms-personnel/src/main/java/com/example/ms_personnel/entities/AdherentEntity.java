package com.example.ms_personnel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("ADHERENT")
public class AdherentEntity extends PersonneEntity {

    private String numeroAdherent;
}