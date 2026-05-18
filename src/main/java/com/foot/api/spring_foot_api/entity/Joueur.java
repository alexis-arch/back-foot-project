package com.foot.api.spring_foot_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "joueur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clé étrangère vers Equipe
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    private String nom;
    private String prenom;
    private Integer numero;
    private String photo;

    @Column(name = "est_remplacant")
    private Boolean estRemplacant;
}