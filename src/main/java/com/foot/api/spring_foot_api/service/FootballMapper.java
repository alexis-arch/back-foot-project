package com.foot.api.spring_foot_api.service;


import com.foot.api.spring_foot_api.dto.*;
import com.foot.api.spring_foot_api.entity.Coach;
import com.foot.api.spring_foot_api.entity.Equipe;
import com.foot.api.spring_foot_api.entity.Joueur;
import com.foot.api.spring_foot_api.entity.Stade;
import org.springframework.stereotype.Component;

@Component
public class FootballMapper {

    public StadeDTO toStadeDTO(Stade s) {
        return StadeDTO.builder()
                .id(s.getId())
                .nom(s.getNom())
                .ville(s.getVille())
                .adresse(s.getAdresse())
                .codePostal(s.getCodePostal())
                .latitude(s.getLatitude())
                .longitude(s.getLongitude())
                .capacite(s.getCapacite())
                .anneeConstruction(s.getAnneeConstruction())
                .anneeRenovation(s.getAnneeRenovation())
                .proprietaire(s.getProprietaire())
                .surface(s.getSurface())
                .architecte(s.getArchitecte())
                .description(s.getDescription())
                .photo(s.getPhoto())
                .build();
    }

    public StadeMarkerDTO toStadeMarkerDTO(Stade s) {
        return StadeMarkerDTO.builder()
                .id(s.getId())
                .nom(s.getNom())
                .ville(s.getVille())
                .latitude(s.getLatitude())
                .longitude(s.getLongitude())
                .capacite(s.getCapacite())
                .build();
    }

    public EquipeDTO toEquipeDTO(Equipe e) {
        return EquipeDTO.builder()
                .id(e.getId())
                .nom(e.getNom())
                .couleurMaillot(e.getCouleurMaillot())
                .logo(e.getLogo())
                .fondation(e.getFondation())
                .president(e.getPresident())
                .budget(e.getBudget())
                .stadeId(e.getStade() != null ? e.getStade().getId() : null)
                .stadeNom(e.getStade() != null ? e.getStade().getNom() : null)
                .build();
    }

    public JoueurDTO toJoueurDTO(Joueur j) {
        return JoueurDTO.builder()
                .id(j.getId())
                .nom(j.getNom())
                .prenom(j.getPrenom())
                .numero(j.getNumero())
                .photo(j.getPhoto())
                .estRemplacant(j.getEstRemplacant())
                .equipeId(j.getEquipe() != null ? j.getEquipe().getId() : null)
                .build();
    }

    public CoachDTO toCoachDTO(Coach c) {
        return CoachDTO.builder()
                .id(c.getId())
                .nom(c.getNom())
                .prenom(c.getPrenom())
                .photo(c.getPhoto())
                .role(c.getRole())
                .equipeId(c.getEquipe() != null ? c.getEquipe().getId() : null)
                .build();
    }
}
