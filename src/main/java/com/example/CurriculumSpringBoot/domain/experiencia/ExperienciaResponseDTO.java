package com.example.CurriculumSpringBoot.domain.experiencia;

import java.time.LocalDateTime;

public record ExperienciaResponseDTO(
        String id,
        String empresa,
        String cargo,
        String descricao,
        LocalDateTime data_inicio,
        LocalDateTime data_fim
) {
    public ExperienciaResponseDTO(Experiencia experiencia){
        this(
                experiencia.getId(),
                experiencia.getEmpresa(),
                experiencia.getCargo(),
                experiencia.getDescricao(),
                experiencia.getData_inicio(),
                experiencia.getData_fim()
        );
    }
}
