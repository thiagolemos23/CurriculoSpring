package com.example.CurriculumSpringBoot.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRequestDTO(
        @NotBlank
        String rua,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String codigo_postal,
        @NotBlank
        String pais,

        @NotBlank
        Long user_id
) {
}
