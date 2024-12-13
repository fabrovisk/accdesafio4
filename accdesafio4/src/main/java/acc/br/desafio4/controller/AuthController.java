package acc.br.desafio4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import acc.br.desafio4.service.AuthService;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean autenticado = authService.autenticar(username, password);

        if (autenticado) {
            return "Login realizado com sucesso!";
        } else {
            return "Credenciais inválidas!";
        }
    }
}
