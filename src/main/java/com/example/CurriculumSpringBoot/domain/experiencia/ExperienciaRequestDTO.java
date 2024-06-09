package com.example.CurriculumSpringBoot.domain.experiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ExperienciaRequestDTO(
        @NotBlank
        String empresa,
        @NotBlank
        String cargo,
        @NotBlank
        String descricao,
        @NotNull
        LocalDateTime data_inicio,
        LocalDateTime data_fim,

        @NotNull
        Long user_id
) {}
