package com.example.CurriculumSpringBoot.domain.educacao;

import java.time.LocalDateTime;

public record EducacaoResponseDTO(
        String id,
        String instituicao,
        String curso,
        LocalDateTime data_inicio,
        LocalDateTime data_conclusao
){
    public EducacaoResponseDTO(Educacao educacao){
        this(
                educacao.getId(),
                educacao.getInstituicao(),
                educacao.getCurso(),
                educacao.getData_inicio(),
                educacao.getData_conclusao()
        );
    }
}
