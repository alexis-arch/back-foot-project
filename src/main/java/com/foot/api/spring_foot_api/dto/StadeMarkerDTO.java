package com.foot.api.spring_foot_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StadeMarkerDTO {
    private Long id;
    private String nom;
    private String ville;
    private Double latitude;
    private Double longitude;
    private String capacite;
}