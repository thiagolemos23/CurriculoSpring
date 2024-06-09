package com.example.CurriculumSpringBoot.domain.endereco;

import com.example.CurriculumSpringBoot.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "endereco")
@Entity(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String rua;
    private String cidade;
    private String estado;
    private String codigo_postal;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Endereco(String rua, String cidade, String estado, String codigo_postal, String pais, User user) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.user = user;
    }
}