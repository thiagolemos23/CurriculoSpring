package com.example.CurriculumSpringBoot.repositories;

import com.example.CurriculumSpringBoot.domain.experiencia.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Experiencia, String> {
}
