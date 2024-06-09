package com.example.CurriculumSpringBoot.repositories;

import com.example.CurriculumSpringBoot.domain.educacao.Educacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducacaoRepository extends JpaRepository<Educacao, String> {
}
