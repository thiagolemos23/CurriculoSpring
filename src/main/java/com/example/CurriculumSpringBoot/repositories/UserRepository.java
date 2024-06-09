package com.example.CurriculumSpringBoot.repositories;

import com.example.CurriculumSpringBoot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
