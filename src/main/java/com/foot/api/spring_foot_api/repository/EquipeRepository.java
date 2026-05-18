package com.foot.api.spring_foot_api.repository;

import com.foot.api.spring_foot_api.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Optional<Equipe> findByStadeId(Long stadeId);

    List<Equipe> findByNomContainingIgnoreCase(String nom);

}
