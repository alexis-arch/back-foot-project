package com.foot.api.spring_foot_api.controller;


import com.foot.api.spring_foot_api.dto.JoueurDTO;
import com.foot.api.spring_foot_api.entity.Joueur;
import com.foot.api.spring_foot_api.service.JoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
@RequiredArgsConstructor
public class JoueurController {
    private final JoueurService joueurService;

    @GetMapping
    public ResponseEntity<Page<JoueurDTO>> getAllJoueurs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(joueurService.getAllJoueurs(PageRequest.of(page, size)));
    }

    @GetMapping("/equipe/{equipeId}")
    public ResponseEntity<List<JoueurDTO>> getJoueursByEquipe(@PathVariable Long equipeId) {
        return ResponseEntity.ok(joueurService.getJoueursByEquipe(equipeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoueurDTO> getJoueurById(@PathVariable Long id) {
        return ResponseEntity.ok(joueurService.getJoueurById(id));
    }

    @PostMapping
    public ResponseEntity<JoueurDTO> createJoueur(@RequestBody Joueur joueur) {
        return ResponseEntity.ok(joueurService.createJoueur(joueur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        joueurService.deleteJoueur(id);
        return ResponseEntity.noContent().build();
    }
}

