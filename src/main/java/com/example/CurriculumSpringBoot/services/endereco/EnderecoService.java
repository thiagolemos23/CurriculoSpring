package com.example.CurriculumSpringBoot.services.endereco;

import com.example.CurriculumSpringBoot.domain.endereco.Endereco;
import com.example.CurriculumSpringBoot.domain.endereco.EnderecoRequestDTO;
import com.example.CurriculumSpringBoot.domain.user.User;
import com.example.CurriculumSpringBoot.repositories.EnderecoRepository;
import com.example.CurriculumSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UserRepository userRepository;

    public Endereco createEndereco(EnderecoRequestDTO registerEnderecoDTO) {

        User user = userRepository.getById(String.valueOf(registerEnderecoDTO.user_id()));

        Endereco endereco = new Endereco(
                registerEnderecoDTO.rua(),
                registerEnderecoDTO.cidade(),
                registerEnderecoDTO.estado(),
                registerEnderecoDTO.codigo_postal(),
                registerEnderecoDTO.pais(),
                user
        );
        return enderecoRepository.save(endereco);
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Endereco not found"));
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco updateEndereco(Long id, EnderecoRequestDTO registerEnderecoDTO) {
        Endereco endereco = getEnderecoById(id);
        endereco.setRua(registerEnderecoDTO.rua());
        endereco.setCidade(registerEnderecoDTO.cidade());
        endereco.setEstado(registerEnderecoDTO.estado());
        endereco.setCodigo_postal(registerEnderecoDTO.codigo_postal());
        endereco.setPais(registerEnderecoDTO.pais());
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(String.valueOf(id));
    }
}
