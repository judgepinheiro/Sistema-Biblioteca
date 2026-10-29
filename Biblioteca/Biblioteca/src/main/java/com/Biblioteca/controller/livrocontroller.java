

package com.Biblioteca.controller;

import com.Biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class livrocontroller {

    @GetMapping({"/", "/livros"})
    public String inicio(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");
        livro.setAnoPublicacao(1899);

        model.addAttribute("titulo", "Sistema de Biblioteca");
        model.addAttribute("mensagem", "Bem-vindo ao Sistema de Biblioteca");
        model.addAttribute("livro", livro);
        return "livros/inicio";
    }

    @GetMapping("/livro")
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");
        livro.setAnoPublicacao(1899);

        model.addAttribute("livro", livro);
        return "livro";
    }

    @GetMapping("/livros/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/livros")
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {
        model.addAttribute("livro", livro);
        return "livros/confirmacao";
    }
}
