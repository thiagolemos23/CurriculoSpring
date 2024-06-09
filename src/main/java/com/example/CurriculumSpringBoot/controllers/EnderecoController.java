package com.example.CurriculumSpringBoot.controllers;

import com.example.CurriculumSpringBoot.domain.endereco.Endereco;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoRequestDTO;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoResponseDTO;
import com.example.CurriculumSpringBoot.services.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> createEndereco(@RequestBody EnderecoRequestDTO registerEnderecoDTO) {
        Endereco endereco = enderecoService.createEndereco(registerEnderecoDTO);
        return ResponseEntity.ok(new EnderecoResponseDTO(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> getEnderecoById(@PathVariable Long id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(new EnderecoResponseDTO(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();
        List<EnderecoResponseDTO> enderecoResponseDTOs = enderecos.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(enderecoResponseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO registerEnderecoDTO) {
        Endereco endereco = enderecoService.updateEndereco(id, registerEnderecoDTO);
        return ResponseEntity.ok(new EnderecoResponseDTO(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
