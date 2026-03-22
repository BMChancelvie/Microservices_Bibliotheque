package com.example.ms_emprunt.client;

import com.example.ms_emprunt.dto.ProduitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-produit", url = "http://localhost:8081")
public interface ProduitClient {

    @GetMapping("/api/produits/{id}")
    ProduitDTO getProduitById(@PathVariable Long id);
}