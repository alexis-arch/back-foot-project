package com.foot.api.spring_foot_api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StadeDetailDTO {
    private StadeDTO stade;
    private EquipeDTO equipe;
    private List<JoueurDTO> joueurs;
    private List<CoachDTO> coachs;
}