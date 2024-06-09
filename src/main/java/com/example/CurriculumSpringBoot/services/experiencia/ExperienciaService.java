package com.example.CurriculumSpringBoot.services.experiencia;

import com.example.CurriculumSpringBoot.domain.experiencia.Experiencia;
import com.example.CurriculumSpringBoot.domain.experiencia.ExperienciaRequestDTO;
import com.example.CurriculumSpringBoot.domain.user.User;
import com.example.CurriculumSpringBoot.repositories.ExperienciaRepository;
import com.example.CurriculumSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private UserRepository userRepository;

    public Experiencia createExperiencia(ExperienciaRequestDTO registerExperienciaDTO) {

        User user = userRepository.getById(String.valueOf(registerExperienciaDTO.user_id()));

        Experiencia experiencia = new Experiencia(
                registerExperienciaDTO.empresa(),
                registerExperienciaDTO.cargo(),
                registerExperienciaDTO.descricao(),
                registerExperienciaDTO.data_inicio(),
                registerExperienciaDTO.data_fim(),
                user
        );
        return experienciaRepository.save(experiencia);
    }

    public Experiencia getExperienciaById(Long id) {
        return experienciaRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Experiencia not found"));
    }

    public List<Experiencia> getAllExperiencias() {
        return experienciaRepository.findAll();
    }

    public Experiencia updateExperiencia(Long id, ExperienciaRequestDTO registerExperienciaDTO) {
        Experiencia experiencia = getExperienciaById(id);
        experiencia.setEmpresa(registerExperienciaDTO.empresa());
        experiencia.setCargo(registerExperienciaDTO.cargo());
        experiencia.setDescricao(registerExperienciaDTO.descricao());
        experiencia.setData_inicio(registerExperienciaDTO.data_inicio());
        experiencia.setData_fim(registerExperienciaDTO.data_fim());
        return experienciaRepository.save(experiencia);
    }

    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(String.valueOf(id));
    }

}
