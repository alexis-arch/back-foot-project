package com.foot.api.spring_foot_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoueurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Integer numero;
    private String photo;
    private Boolean estRemplacant;
    private Long equipeId;
}
