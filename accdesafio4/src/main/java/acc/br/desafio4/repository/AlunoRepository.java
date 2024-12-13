package acc.br.desafio4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acc.br.desafio4.model.Aluno;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    Optional<Aluno> findById(Long id);

    List<Aluno> findAll();
}
