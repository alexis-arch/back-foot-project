package com.foot.api.spring_foot_api.service;


import com.foot.api.spring_foot_api.dto.JoueurDTO;
import com.foot.api.spring_foot_api.entity.Joueur;
import com.foot.api.spring_foot_api.repository.JoueurRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoueurService {
    private final JoueurRepository joueurRepository;
    private final FootballMapper mapper;

    public Page<JoueurDTO> getAllJoueurs(Pageable pageable) {
        return joueurRepository.findAll(pageable)
                .map(mapper::toJoueurDTO);
    }
    public List<JoueurDTO> getJoueursByEquipe(Long equipeId) {
        return joueurRepository.findByEquipeId(equipeId)
                .stream()
                .map(mapper::toJoueurDTO)
                .collect(Collectors.toList());
    }

    public JoueurDTO getJoueurById(Long id) {
        return joueurRepository.findById(id)
                .map(mapper::toJoueurDTO)
                .orElseThrow(() -> new EntityNotFoundException("Joueur introuvable id=" + id));
    }

    @Transactional
    public JoueurDTO createJoueur(Joueur joueur) {
        return mapper.toJoueurDTO(joueurRepository.save(joueur));
    }

    @Transactional
    public void deleteJoueur(Long id) {
        joueurRepository.deleteById(id);
    }

}

