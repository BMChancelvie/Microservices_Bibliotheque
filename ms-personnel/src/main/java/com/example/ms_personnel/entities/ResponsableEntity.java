package com.example.ms_personnel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("RESPONSABLE")
public class ResponsableEntity extends EmployeEntity {

    private String niveauResponsabilite;
}