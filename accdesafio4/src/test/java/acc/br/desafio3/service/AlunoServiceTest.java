package  acc.br.desafio3.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import acc.br.desafio4.model.Aluno;
import acc.br.desafio4.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {

    @Autowired
    private AlunoRepository estudanteRepository;

    @Test
    public void quandoEstudanteSalvoEntãoDeveExistir() {
        Aluno estudante = new Aluno();
        estudanteRepository.save(estudante);
        assertThat(estudanteRepository.findById(estudante.getId())).isPresent();
    }
}
