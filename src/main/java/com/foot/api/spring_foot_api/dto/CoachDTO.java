package com.foot.api.spring_foot_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoachDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String photo;
    private String role;
    private Long equipeId;
}
