package acc.br.desafio4.model;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.*;

@Entity
@Table(name = "login") // Nome da tabela no banco de dados
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Usuario findByUsername(String username);
    }
}
