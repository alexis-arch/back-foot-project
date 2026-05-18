package com.foot.api.spring_foot_api.controller;


import com.foot.api.spring_foot_api.dto.CoachDTO;
import com.foot.api.spring_foot_api.entity.Coach;
import com.foot.api.spring_foot_api.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coachs")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoachs() {
        return ResponseEntity.ok(coachService.getAllCoachs());
    }

    @GetMapping("/equipe/{equipeId}")
    public ResponseEntity<List<CoachDTO>> getCoachsByEquipe(@PathVariable Long equipeId) {
        return ResponseEntity.ok(coachService.getCoachsByEquipe(equipeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable Long id) {
        return ResponseEntity.ok(coachService.getCoachById(id));
    }

    @PostMapping
    public ResponseEntity<CoachDTO> createCoach(@RequestBody Coach coach) {
        return ResponseEntity.ok(coachService.createCoach(coach));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}
