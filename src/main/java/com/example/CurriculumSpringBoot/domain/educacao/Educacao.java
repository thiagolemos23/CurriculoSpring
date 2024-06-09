package com.example.CurriculumSpringBoot.domain.educacao;

import com.example.CurriculumSpringBoot.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "educacao")
@Entity(name = "educacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Educacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String instituicao;
    private String curso;
    private LocalDateTime data_inicio;
    private LocalDateTime data_conclusao;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Educacao(String instituicao, String curso, LocalDateTime data_inicio, LocalDateTime data_conclusao, User user) {
        this.instituicao = instituicao;
        this.curso = curso;
        this.data_inicio = data_inicio;
        this.data_conclusao = data_conclusao;
        this.user = user;
    }
}