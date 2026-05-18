package com.foot.api.spring_foot_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "equipe")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clé étrangère vers Stade
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stade_id")
    private Stade stade;

    @Column(nullable = false)
    private String nom;

    @Column(name = "couleur_maillot")
    private String couleurMaillot;

    private String logo;
    private Integer fondation;
    private String president;
    private String budget;

    // Relation : une équipe possède des joueurs
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Joueur> joueurs;

    // Relation : une équipe est encadrée par des coachs
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private List<Coach> coachs;
}
