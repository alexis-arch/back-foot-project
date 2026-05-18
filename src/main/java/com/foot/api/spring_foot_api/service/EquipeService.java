package com.foot.api.spring_foot_api.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foot.api.spring_foot_api.dto.EquipeDTO;
import com.foot.api.spring_foot_api.entity.Equipe;
import com.foot.api.spring_foot_api.repository.EquipeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquipeService {
    private final EquipeRepository equipeRepository;
    private final FootballMapper mapper;

    public List<EquipeDTO> getAllEquipes() {
        return equipeRepository.findAll()
                .stream()
                .map(mapper::toEquipeDTO)
                .collect(Collectors.toList());
    }

    public EquipeDTO getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .map(mapper::toEquipeDTO)
                .orElseThrow(() -> new EntityNotFoundException("Equipe introuvable id=" + id));
    }

    public EquipeDTO getEquipeByStadeId(Long stadeId) {
        return equipeRepository.findByStadeId(stadeId)
                .map(mapper::toEquipeDTO)
                .orElseThrow(() -> new EntityNotFoundException("Aucune équipe pour le stade id=" + stadeId));
    }

    @Transactional
    public EquipeDTO createEquipe(Equipe equipe) {
        return mapper.toEquipeDTO(equipeRepository.save(equipe));
    }

    @Transactional
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
