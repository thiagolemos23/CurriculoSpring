package com.example.CurriculumSpringBoot.domain.user;

import com.example.CurriculumSpringBoot.domain.educacao.EducacaoRequestDTO;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoRequestDTO;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaRequestDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record RegisterDTO(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        @Email
        String email,
        String telefone,
        @NotEmpty
        List<String> tecnologias,
        List<EnderecoRequestDTO> enderecos,
        List<EducacaoRequestDTO> educacoes,
        List<ExperienciaRequestDTO> experiencias

) {
}
