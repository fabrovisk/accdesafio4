package acc.br.desafio4.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import acc.br.desafio4.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        if (loginService.validateLogin(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/"; 
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos"); 
            return "login"; 
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
