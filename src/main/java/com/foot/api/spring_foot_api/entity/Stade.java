package com.foot.api.spring_foot_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "stade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String ville;
    private String adresse;

    @Column(name = "code_postal")
    private Integer codePostal;

    private Double latitude;
    private Double longitude;
    private String capacite;

    @Column(name = "annee_construction")
    private Integer anneeConstruction;

    @Column(name = "annee_renovation")
    private String anneeRenovation;

    private String proprietaire;
    private String surface;
    private String architecte;
    @Column(name = "photo")
    private String photo;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Relation : un stade héberge une ou plusieurs équipes
    @OneToMany(mappedBy = "stade", fetch = FetchType.LAZY)
    private List<Equipe> equipes;


}
