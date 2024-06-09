package com.example.CurriculumSpringBoot.domain.educacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record EducacaoRequestDTO(
        @NotBlank
        String instituicao,
        @NotBlank
        String curso,
        @NotNull
        LocalDateTime data_inicio,
        LocalDateTime data_conclusao,
        @NotBlank
        Long user_id

){}
