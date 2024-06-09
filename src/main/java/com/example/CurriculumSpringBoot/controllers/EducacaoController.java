package com.example.CurriculumSpringBoot.controllers;

import com.example.CurriculumSpringBoot.domain.educacao.Educacao;
import com.example.CurriculumSpringBoot.domain.educacao.EducacaoRequestDTO;
import com.example.CurriculumSpringBoot.domain.educacao.EducacaoResponseDTO;
import com.example.CurriculumSpringBoot.services.educacao.EducacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/educacao")
public class EducacaoController {

    @Autowired
    private EducacaoService educacaoService;

    @PostMapping
    public ResponseEntity<EducacaoResponseDTO> createEducacao(@RequestBody EducacaoRequestDTO registerEducacaoDTO) {
        Educacao educacao = educacaoService.createEducacao(registerEducacaoDTO);
        return ResponseEntity.ok(new EducacaoResponseDTO(educacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducacaoResponseDTO> getEducacaoById(@PathVariable Long id) {
        Educacao educacao = educacaoService.getEducacaoById(id);
        return ResponseEntity.ok(new EducacaoResponseDTO(educacao));
    }

    @GetMapping
    public ResponseEntity<List<EducacaoResponseDTO>> getAllEducacoes() {
        List<Educacao> educacoes = educacaoService.getAllEducacoes();
        List<EducacaoResponseDTO> educacaoResponseDTOs = educacoes.stream().map(EducacaoResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(educacaoResponseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducacaoResponseDTO> updateEducacao(@PathVariable Long id, @RequestBody EducacaoRequestDTO registerEducacaoDTO) {
        Educacao educacao = educacaoService.updateEducacao(id, registerEducacaoDTO);
        return ResponseEntity.ok(new EducacaoResponseDTO(educacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducacao(@PathVariable Long id) {
        educacaoService.deleteEducacao(id);
        return ResponseEntity.noContent().build();
    }

}
