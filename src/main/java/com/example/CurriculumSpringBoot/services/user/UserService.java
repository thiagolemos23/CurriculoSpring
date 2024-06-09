package com.example.CurriculumSpringBoot.services.user;

import com.example.CurriculumSpringBoot.domain.educacao.Educacao;
import com.example.CurriculumSpringBoot.domain.educacao.EducacaoRequestDTO;
import com.example.CurriculumSpringBoot.domain.endereco.Endereco;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoRequestDTO;
import com.example.CurriculumSpringBoot.domain.experiencia.Experiencia;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaRequestDTO;
import com.example.CurriculumSpringBoot.domain.user.RegisterDTO;
import com.example.CurriculumSpringBoot.domain.user.User;
import com.example.CurriculumSpringBoot.repositories.EducacaoRepository;
import com.example.CurriculumSpringBoot.repositories.EnderecoRepository;
import com.example.CurriculumSpringBoot.repositories.ExperienciaRepository;
import com.example.CurriculumSpringBoot.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EducacaoRepository educacaoRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Transactional
    public User registerUser(RegisterDTO registerUserDTO) {
        User user = new User(
                registerUserDTO.nome(),
                registerUserDTO.sobrenome(),
                registerUserDTO.email(),
                registerUserDTO.telefone(),
                registerUserDTO.tecnologias()
        );

        user = userRepository.save(user);

        for (EnderecoRequestDTO enderecoDTO : registerUserDTO.enderecos()) {
            Endereco endereco = new Endereco(
                    enderecoDTO.rua(),
                    enderecoDTO.cidade(),
                    enderecoDTO.estado(),
                    enderecoDTO.codigo_postal(),
                    enderecoDTO.pais(),
                    user
            );
            enderecoRepository.save(endereco);
        }

        for (EducacaoRequestDTO educacaoDTO : registerUserDTO.educacoes()) {
            Educacao educacao = new Educacao(
                    educacaoDTO.instituicao(),
                    educacaoDTO.curso(),
                    educacaoDTO.data_inicio(),
                    educacaoDTO.data_conclusao(),
                    user
            );
            educacaoRepository.save(educacao);
        }

        for (ExperienciaRequestDTO experienciaDTO : registerUserDTO.experiencias()) {
            Experiencia experiencia = new Experiencia(
                    experienciaDTO.empresa(),
                    experienciaDTO.cargo(),
                    experienciaDTO.descricao(),
                    experienciaDTO.data_inicio(),
                    experienciaDTO.data_fim(),
                    user
            );
            experienciaRepository.save(experiencia);
        }

        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, RegisterDTO registerUserDTO) {
        User user = getUserById(id);
        user.setNome(registerUserDTO.nome());
        user.setSobrenome(registerUserDTO.sobrenome());
        user.setEmail(registerUserDTO.email());
        user.setTelefone(registerUserDTO.telefone());
        user.setTecnologias(registerUserDTO.tecnologias());

        // Update nested entities
        user.getEndereco().clear();
        for (EnderecoRequestDTO enderecoDTO : registerUserDTO.enderecos()) {
            Endereco endereco = new Endereco(
                    enderecoDTO.rua(),
                    enderecoDTO.cidade(),
                    enderecoDTO.estado(),
                    enderecoDTO.codigo_postal(),
                    enderecoDTO.pais(),
                    user
            );
            user.getEndereco().add(endereco);
        }

        user.getEducacao().clear();
        for (EducacaoRequestDTO educacaoDTO : registerUserDTO.educacoes()) {
            Educacao educacao = new Educacao(
                    educacaoDTO.instituicao(),
                    educacaoDTO.curso(),
                    educacaoDTO.data_inicio(),
                    educacaoDTO.data_conclusao(),
                    user
            );
            user.getEducacao().add(educacao);
        }

        user.getExperiencia().clear();
        for (ExperienciaRequestDTO experienciaDTO : registerUserDTO.experiencias()) {
            Experiencia experiencia = new Experiencia(
                    experienciaDTO.empresa(),
                    experienciaDTO.cargo(),
                    experienciaDTO.descricao(),
                    experienciaDTO.data_inicio(),
                    experienciaDTO.data_fim(),
                    user
            );
            user.getExperiencia().add(experiencia);
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }
}
