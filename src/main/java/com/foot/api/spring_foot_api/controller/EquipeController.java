package com.foot.api.spring_foot_api.controller;

import com.foot.api.spring_foot_api.dto.EquipeDTO;
import com.foot.api.spring_foot_api.entity.Equipe;
import com.foot.api.spring_foot_api.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@RequiredArgsConstructor
public class EquipeController {
    private final EquipeService equipeService;

    @GetMapping
    public ResponseEntity<List<EquipeDTO>> getAllEquipes() {
        return ResponseEntity.ok(equipeService.getAllEquipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDTO> getEquipeById(@PathVariable Long id) {
        return ResponseEntity.ok(equipeService.getEquipeById(id));
    }

    // Pratique : récupérer l'équipe d'un stade depuis l'onglet Équipe du drawer
    @GetMapping("/stade/{stadeId}")
    public ResponseEntity<EquipeDTO> getEquipeByStade(@PathVariable Long stadeId) {
        return ResponseEntity.ok(equipeService.getEquipeByStadeId(stadeId));
    }

    @PostMapping
    public ResponseEntity<EquipeDTO> createEquipe(@RequestBody Equipe equipe) {
        return ResponseEntity.ok(equipeService.createEquipe(equipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
        return ResponseEntity.noContent().build();
    }
}
