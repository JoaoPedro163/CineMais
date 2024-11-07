package com.cinemais.cinemais.controller;

import com.cinemais.cinemais.model.filme;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class cinemaisController {

    private List<filme> listaFilmes = new ArrayList();
    
    @GetMapping("/index")
    public String exibirIndex() {
        return "index";
    }

    @GetMapping("/cadastrar")
    public String exibirCadastrar(Model model) {
        model.addAttribute("filme", new filme());
        return "cadastrar";
    }
    
    @PostMapping("/cadastrar")
    public String processarFormulario(@ModelAttribute filme filme, Model model){
        listaFilmes.add(filme);
        model.addAttribute("filme", filme);
        return "redirect:/avaliar";
    }
    
    @GetMapping("/avaliar")
    public String exibirAvaliar(Model model){     
        model.addAttribute("listaFilmes", listaFilmes);
        return "avaliar";
    }
}
