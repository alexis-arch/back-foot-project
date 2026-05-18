package com.foot.api.spring_foot_api.service;

import com.foot.api.spring_foot_api.dto.*;
import com.foot.api.spring_foot_api.entity.Equipe;
import com.foot.api.spring_foot_api.entity.Stade;
import com.foot.api.spring_foot_api.repository.CoachRepository;
import com.foot.api.spring_foot_api.repository.EquipeRepository;
import com.foot.api.spring_foot_api.repository.JoueurRepository;
import com.foot.api.spring_foot_api.repository.StadeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StadeService {

    private final StadeRepository stadeRepository;
    private final EquipeRepository equipeRepository;
    private final JoueurRepository joueurRepository;
    private final CoachRepository coachRepository;
    private final FootballMapper mapper;



    // ── Marqueurs carte ─────────────────────────
    public List<StadeMarkerDTO> getAllMarkers() {
        return stadeRepository.findAllWithCoordinates()
                .stream()
                .map(mapper::toStadeMarkerDTO)
                .collect(Collectors.toList());
    }

    // ── Liste complète des stades ────────────────
    public List<StadeDTO> getAllStades() {
        return stadeRepository.findAll()
                .stream()
                .map(mapper::toStadeDTO)
                .collect(Collectors.toList());
    }

    // ── Détail d'un stade ────────────────────────
    public StadeDTO getStadeById(Long id) {
        Stade stade = stadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stade introuvable id=" + id));
        return mapper.toStadeDTO(stade);
    }

    // ── Drawer complet (stade + équipe + joueurs + coachs) ──
    public StadeDetailDTO getStadeDetail(Long stadeId) {
        Stade stade = stadeRepository.findById(stadeId)
                .orElseThrow(() -> new EntityNotFoundException("Stade introuvable id=" + stadeId));

        Equipe equipe = equipeRepository.findByStadeId(stadeId).orElse(null);

        List<JoueurDTO> joueurs = List.of();
        List<CoachDTO> coachs = List.of();

        if (equipe != null) {
            joueurs = joueurRepository.findByEquipeId(equipe.getId())
                    .stream()
                    .map(mapper::toJoueurDTO)
                    .collect(Collectors.toList());

            coachs = coachRepository.findByEquipeId(equipe.getId())
                    .stream()
                    .map(mapper::toCoachDTO)
                    .collect(Collectors.toList());
        }

        return StadeDetailDTO.builder()
                .stade(mapper.toStadeDTO(stade))
                .equipe(equipe != null ? mapper.toEquipeDTO(equipe) : null)
                .joueurs(joueurs)
                .coachs(coachs)
                .build();
    }

    // ── Recherche par ville ──────────────────────
    public List<StadeDTO> getStadesByVille(String ville) {
        return stadeRepository.findByVilleIgnoreCase(ville)
                .stream()
                .map(mapper::toStadeDTO)
                .collect(Collectors.toList());
    }

    // ── CRUD ─────────────────────────────────────
    @Transactional
    public StadeDTO createStade(Stade stade) {
        return mapper.toStadeDTO(stadeRepository.save(stade));
    }

    @Transactional
    public StadeDTO updateStade(Long id, Stade updated) {
        Stade existing = stadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stade introuvable id=" + id));

        existing.setNom(updated.getNom());
        existing.setVille(updated.getVille());
        existing.setAdresse(updated.getAdresse());
        existing.setCodePostal(updated.getCodePostal());
        existing.setLatitude(updated.getLatitude());
        existing.setLongitude(updated.getLongitude());
        existing.setCapacite(updated.getCapacite());
        existing.setAnneeConstruction(updated.getAnneeConstruction());
        existing.setAnneeRenovation(updated.getAnneeRenovation());
        existing.setProprietaire(updated.getProprietaire());
        existing.setSurface(updated.getSurface());
        existing.setArchitecte(updated.getArchitecte());
        existing.setDescription(updated.getDescription());

        return mapper.toStadeDTO(stadeRepository.save(existing));
    }

    @Transactional
    public void deleteStade(Long id) {
        stadeRepository.deleteById(id);
    }
}