package acc.br.desafio4.service;

import acc.br.desafio4.model.Aluno;
import acc.br.desafio4.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        Optional<Aluno> existing = alunoRepository.findById(id);
        if (existing.isPresent()) {
            Aluno _aluno = existing.get();
            _aluno.setNome(aluno.getNome());
            _aluno.setCurso(aluno.getCurso());
            _aluno.setCep(aluno.getCep());
            _aluno.setDataNascimento(aluno.getDataNascimento());
            _aluno.setLocalidade(aluno.getLocalidade());
            return alunoRepository.save(_aluno);
        }
        return null;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
