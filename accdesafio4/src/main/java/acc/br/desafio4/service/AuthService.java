package acc.br.desafio4.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import acc.br.desafio4.model.Usuario;
import acc.br.desafio4.repository.UsuarioRepository;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean autenticar(String username, String senhaInserida) {
        // Busca o usuário pelo nome
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            // Usuário não encontrado
            return false;
        }

        // Verifica se a senha inserida corresponde ao hash armazenado
        return passwordEncoder.matches(senhaInserida, usuario.getPassword());
    }

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
}
