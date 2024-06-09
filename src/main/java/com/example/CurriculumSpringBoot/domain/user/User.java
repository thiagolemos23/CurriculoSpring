package com.example.CurriculumSpringBoot.domain.user;

import com.example.CurriculumSpringBoot.domain.educacao.Educacao;
import com.example.CurriculumSpringBoot.domain.endereco.Endereco;
import com.example.CurriculumSpringBoot.domain.experiencia.Experiencia;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;

    @ElementCollection
    private List<String> tecnologias;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> endereco;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Educacao> educacao;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Experiencia> experiencia;

    public User(String nome, String sobrenome, String email, String telefone, List<String> tecnologias) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.tecnologias = tecnologias;
    }

}
