


package com.Biblioteca.controller;

import com.Biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AutorController {

    private final List<Autor> autores = new ArrayList<>();
    private Long proximoId = 1L;

    @GetMapping("/autores/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "Autor/cadastro-autor";
    }

    @PostMapping("/autores/salvar")
    public String salvarAutor(@ModelAttribute Autor autor) {
        autor.setId(proximoId++);
        autores.add(autor);

        return "redirect:/autores/novo";
    }

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        model.addAttribute("autores", autores);
        return "Autor/lista-autores";
    }
}
