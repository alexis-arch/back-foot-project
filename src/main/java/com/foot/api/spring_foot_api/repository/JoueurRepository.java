package com.foot.api.spring_foot_api.repository;

import com.foot.api.spring_foot_api.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByEquipeId(Long equipeId);

    List<Joueur> findByEquipeIdAndEstRemplacant(Long equipeIdLong, Boolean estRemplacant);
}
