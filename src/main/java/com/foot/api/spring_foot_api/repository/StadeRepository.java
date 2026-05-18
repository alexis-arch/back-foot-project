package com.foot.api.spring_foot_api.repository;

import com.foot.api.spring_foot_api.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {
    // Tous les stades d'une ville
    List<Stade> findByVilleIgnoreCase(String ville);

    // Recherche par nom
    List<Stade> findByNomContainingIgnoreCase(String nom);

    // Stades avec coordonnées valides (pour la carte)
    @Query("SELECT s FROM Stade s WHERE s.latitude IS NOT NULL AND s.longitude IS NOT NULL")
    List<Stade> findAllWithCoordinates();
}

