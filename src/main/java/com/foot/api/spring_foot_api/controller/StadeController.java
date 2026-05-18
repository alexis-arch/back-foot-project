package com.foot.api.spring_foot_api.controller;


import com.foot.api.spring_foot_api.dto.StadeDTO;
import com.foot.api.spring_foot_api.dto.StadeDetailDTO;
import com.foot.api.spring_foot_api.dto.StadeMarkerDTO;
import com.foot.api.spring_foot_api.entity.Stade;
import com.foot.api.spring_foot_api.service.StadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stades")
@RequiredArgsConstructor
public class StadeController {

    private final StadeService stadeService;

    /**
     * GET /api/stades/markers
     * → Tous les marqueurs pour la carte (léger, lat/lng seulement)
     */
    @GetMapping("/markers")
    public ResponseEntity<List<StadeMarkerDTO>> getMarkers() {
        return ResponseEntity.ok(stadeService.getAllMarkers());
    }

    /**
     * GET /api/stades
     * → Liste complète des stades
     */
    @GetMapping
    public ResponseEntity<List<StadeDTO>> getAllStades(
            @RequestParam(required = false) String ville) {
        if (ville != null && !ville.isBlank()) {
            return ResponseEntity.ok(stadeService.getStadesByVille(ville));
        }
        return ResponseEntity.ok(stadeService.getAllStades());
    }

    /**
     * GET /api/stades/{id}
     * → Détail d'un stade
     */
    @GetMapping("/{id}")
    public ResponseEntity<StadeDTO> getStadeById(@PathVariable Long id) {
        return ResponseEntity.ok(stadeService.getStadeById(id));
    }

    /**
     * GET /api/stades/{id}/detail
     * → Tout ce qu'il faut pour le drawer Angular :
     *    stade + équipe + joueurs + coachs en 1 seul appel
     */
    @GetMapping("/{id}/detail")
    public ResponseEntity<StadeDetailDTO> getStadeDetail(@PathVariable Long id) {
        return ResponseEntity.ok(stadeService.getStadeDetail(id));
    }

    /**
     * POST /api/stades
     */
    @PostMapping
    public ResponseEntity<StadeDTO> createStade(@RequestBody Stade stade) {
        return ResponseEntity.ok(stadeService.createStade(stade));
    }

    /**
     * PUT /api/stades/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<StadeDTO> updateStade(
            @PathVariable Long id,
            @RequestBody Stade stade) {
        return ResponseEntity.ok(stadeService.updateStade(id, stade));
    }

    /**
     * DELETE /api/stades/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStade(@PathVariable Long id) {
        stadeService.deleteStade(id);
        return ResponseEntity.noContent().build();
    }


}

