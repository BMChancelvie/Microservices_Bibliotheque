package com.example.ms_personnel.repository;

import com.example.ms_personnel.entities.PersonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<PersonneEntity, Long> {
}