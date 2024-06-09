package com.example.CurriculumSpringBoot.domain.endereco;

public record EnderecoResponseDTO(
        String id,
        String rua,
        String cidade,
        String estado,
        String codigo_postal,
        String pais
) {
    public EnderecoResponseDTO(Endereco endereco){
        this(
                endereco.getId(),
                endereco.getRua(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCodigo_postal(),
                endereco.getPais()
        );
    }
}

