package com.example.ms_emprunt.repository;

import com.example.ms_emprunt.entities.EmpruntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<EmpruntEntity,Long> {
}