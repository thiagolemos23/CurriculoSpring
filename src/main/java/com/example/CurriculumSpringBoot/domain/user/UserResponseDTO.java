package com.example.CurriculumSpringBoot.domain.user;

import com.example.CurriculumSpringBoot.domain.educacao.EducacaoResponseDTO;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoResponseDTO;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public record UserResponseDTO(
            String id,
            String nome,
            String sobrenome,
            String email,
            String telefone,
            List<String> tecnologias,
            List<EnderecoResponseDTO> enderecos,
            List<EducacaoResponseDTO> educacoes,
            List<ExperienciaResponseDTO> experiencias
        ) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getSobrenome(),
                user.getEmail(),
                user.getTelefone(),
                user.getTecnologias(),
                user.getEndereco() != null ? user.getEndereco().stream().map(EnderecoResponseDTO::new).collect(Collectors.toList()) : List.of(),
                user.getEducacao() != null ? user.getEducacao().stream().map(EducacaoResponseDTO::new).collect(Collectors.toList()) : List.of(),
                user.getExperiencia() != null ? user.getExperiencia().stream().map(ExperienciaResponseDTO::new).collect(Collectors.toList()) : List.of()
        );
    }
}
