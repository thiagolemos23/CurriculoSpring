// ChatController.java
package com.example.CurriculumSpringBoot.controllers;

import com.example.CurriculumSpringBoot.domain.experiencia.Experiencia;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaRequestDTO;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaResponseDTO;
import com.example.CurriculumSpringBoot.services.experiencia.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @PostMapping
    public ResponseEntity<ExperienciaResponseDTO> createExperiencia(@RequestBody ExperienciaRequestDTO registerExperienciaDTO) {
        Experiencia experiencia = experienciaService.createExperiencia(registerExperienciaDTO);
        return ResponseEntity.ok(new ExperienciaResponseDTO(experiencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaResponseDTO> getExperienciaById(@PathVariable Long id) {
        Experiencia experiencia = experienciaService.getExperienciaById(id);
        return ResponseEntity.ok(new ExperienciaResponseDTO(experiencia));
    }

    @GetMapping
    public ResponseEntity<List<ExperienciaResponseDTO>> getAllExperiencias() {
        List<Experiencia> experiencias = experienciaService.getAllExperiencias();
        List<ExperienciaResponseDTO> experienciaResponseDTOs = experiencias.stream().map(ExperienciaResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(experienciaResponseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaResponseDTO> updateExperiencia(@PathVariable Long id, @RequestBody ExperienciaRequestDTO registerExperienciaDTO) {
        Experiencia experiencia = experienciaService.updateExperiencia(id, registerExperienciaDTO);
        return ResponseEntity.ok(new ExperienciaResponseDTO(experiencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperiencia(@PathVariable Long id) {
        experienciaService.deleteExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
