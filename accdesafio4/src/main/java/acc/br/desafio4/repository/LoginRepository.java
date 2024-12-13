package acc.br.desafio4.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import acc.br.desafio4.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
