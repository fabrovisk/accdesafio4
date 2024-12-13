package acc.br.desafio4.controller;

import acc.br.desafio4.model.Aluno;
import acc.br.desafio4.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("alunos", alunoService.findAll());
        return "index";
    }

    @PostMapping
    public String createAluno(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/index/{id}")
    public String editAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            model.addAttribute("aluno", aluno);
            return "index";
        } else {
            return "redirect:/alunos/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        alunoService.update(id, aluno);
        return "redirect:/alunos/index";
    }

    @PostMapping("/delete/{id}")
    public String deleteAluno(@PathVariable Long id) {
        alunoService.delete(id);
        return "redirect:/alunos/index";
    }
}
