package com.foot.api.spring_foot_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipeDTO {
    private Long id;
    private String nom;
    private String couleurMaillot;
    private String logo;
    private Integer fondation;
    private String president;
    private String budget;
    private Long stadeId;
    private String stadeNom;
}