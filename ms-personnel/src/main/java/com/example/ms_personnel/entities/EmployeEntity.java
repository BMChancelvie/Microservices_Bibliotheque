package com.example.ms_personnel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("EMPLOYE")
public class EmployeEntity extends PersonneEntity {

    private String poste;

    @ManyToOne
    private ServiceEntity service;
}