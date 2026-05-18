package com.foot.api.spring_foot_api.service;


import com.foot.api.spring_foot_api.dto.CoachDTO;
import com.foot.api.spring_foot_api.entity.Coach;
import com.foot.api.spring_foot_api.repository.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CoachService {

    private final CoachRepository coachRepository;
    private final FootballMapper mapper;

    public List<CoachDTO> getAllCoachs() {
        return coachRepository.findAll()
                .stream()
                .map(mapper::toCoachDTO)
                .collect(Collectors.toList());
    }

    public List<CoachDTO> getCoachsByEquipe(Long equipeId) {
        return coachRepository.findByEquipeId(equipeId)
                .stream()
                .map(mapper::toCoachDTO)
                .collect(Collectors.toList());
    }

    public CoachDTO getCoachById(Long id) {
        return coachRepository.findById(id)
                .map(mapper::toCoachDTO)
                .orElseThrow(() -> new EntityNotFoundException("Coach introuvable id=" + id));
    }

    @Transactional
    public CoachDTO createCoach(Coach coach) {
        return mapper.toCoachDTO(coachRepository.save(coach));
    }

    @Transactional
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }

}

