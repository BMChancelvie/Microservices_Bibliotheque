package com.example.ms_personnel.controller;

import com.example.ms_personnel.dto.ServiceDTO;
import com.example.ms_personnel.entities.ServiceEntity;
import com.example.ms_personnel.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceRepository serviceRepository;

    // CREATE
    @PostMapping
    public ServiceDTO create(@RequestBody ServiceDTO dto){

        ServiceEntity entity = new ServiceEntity();
        entity.setNom(dto.getNom());

        entity = serviceRepository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

    // READ ALL
    @GetMapping
    public List<ServiceDTO> getAll(){
        return serviceRepository.findAll()
                .stream()
                .map(s -> {
                    ServiceDTO dto = new ServiceDTO();
                    dto.setId(s.getId());
                    dto.setNom(s.getNom());
                    return dto;
                })
                .toList();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ServiceDTO getById(@PathVariable Long id){

        ServiceEntity s = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service introuvable"));

        ServiceDTO dto = new ServiceDTO();
        dto.setId(s.getId());
        dto.setNom(s.getNom());

        return dto;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ServiceDTO update(@PathVariable Long id,
                             @RequestBody ServiceDTO dto){

        ServiceEntity s = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service introuvable"));

        s.setNom(dto.getNom());

        serviceRepository.save(s);

        dto.setId(s.getId());
        return dto;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceRepository.deleteById(id);
    }
}