package com.example.CurriculumSpringBoot.domain.experiencia;

import com.example.CurriculumSpringBoot.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "experiencia")
@Table(name = "experiencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String empresa;
    private String cargo;
    private String descricao;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Experiencia(String empresa, String cargo, String descricao, LocalDateTime data_inicio, LocalDateTime data_fim, User user) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.user = user;
    }
}
