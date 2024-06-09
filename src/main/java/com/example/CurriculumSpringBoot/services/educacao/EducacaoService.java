package com.example.CurriculumSpringBoot.services.educacao;

import com.example.CurriculumSpringBoot.domain.educacao.Educacao;
import com.example.CurriculumSpringBoot.domain.educacao.EducacaoRequestDTO;
import com.example.CurriculumSpringBoot.domain.user.User;
import com.example.CurriculumSpringBoot.repositories.EducacaoRepository;
import com.example.CurriculumSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacaoService {

    @Autowired
    private EducacaoRepository educacaoRepository;

    @Autowired
    private UserRepository userRepository;

    public Educacao createEducacao(EducacaoRequestDTO registerEducacaoDTO) {

        User user = userRepository.getById(String.valueOf(registerEducacaoDTO.user_id()));

        Educacao educacao = new Educacao(
                registerEducacaoDTO.instituicao(),
                registerEducacaoDTO.curso(),
                registerEducacaoDTO.data_inicio(),
                registerEducacaoDTO.data_conclusao(),
                user
        );
        return educacaoRepository.save(educacao);
    }

    public Educacao getEducacaoById(Long id) {
        return educacaoRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Educacao not found"));
    }

    public List<Educacao> getAllEducacoes() {
        return educacaoRepository.findAll();
    }

    public Educacao updateEducacao(Long id, EducacaoRequestDTO registerEducacaoDTO) {
        Educacao educacao = getEducacaoById(id);
        educacao.setInstituicao(registerEducacaoDTO.instituicao());
        educacao.setCurso(registerEducacaoDTO.curso());
        educacao.setData_inicio(registerEducacaoDTO.data_inicio());
        educacao.setData_conclusao(registerEducacaoDTO.data_conclusao());
        return educacaoRepository.save(educacao);
    }

    public void deleteEducacao(Long id) {
        educacaoRepository.deleteById(String.valueOf(id));
    }
}
