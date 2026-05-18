package com.foot.api.spring_foot_api.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StadeDTO {
    private Long id;
    private String nom;
    private String ville;
    private String adresse;
    private Integer codePostal;
    private Double latitude;
    private Double longitude;
    private String capacite;
    private Integer anneeConstruction;
    private String anneeRenovation;
    private String proprietaire;
    private String surface;
    private String architecte;
    private String description;
}
