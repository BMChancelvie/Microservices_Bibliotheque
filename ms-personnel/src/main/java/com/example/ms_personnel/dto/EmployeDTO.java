package com.example.ms_personnel.dto;

import lombok.Data;

@Data
public class EmployeDTO extends PersonneDTO {

    private String poste;
    private Long serviceId;
}