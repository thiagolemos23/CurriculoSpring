package com.example.CurriculumSpringBoot.repositories;

import com.example.CurriculumSpringBoot.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
