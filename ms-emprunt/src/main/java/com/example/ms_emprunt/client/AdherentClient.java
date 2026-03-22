package com.example.ms_emprunt.client;

//import com.example.ms_emprunt.dto.AdherentDTO;
import com.example.ms_personnel.dto.PersonneDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// ici, on appelle le microservice ms-personnel

@FeignClient(name = "ms-personnel", url = "http://localhost:8083")
public interface AdherentClient {

    @GetMapping("/api/personnes/{id}")
    PersonneDTO getAdherentById(@PathVariable Long id);
}