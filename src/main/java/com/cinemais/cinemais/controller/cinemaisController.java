package com.cinemais.cinemais.controller;

import com.cinemais.cinemais.model.Avaliacao;
import com.cinemais.cinemais.model.filme;
import com.cinemais.cinemais.service.FilmesService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class cinemaisController {

    private List<filme> listaFilmes = new ArrayList<>();
    private List<Avaliacao> listaAvaliacoes = new ArrayList<>();
    @Autowired
    private FilmesService filmeService;
    
    
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
    public String processarFormulario(@ModelAttribute filme filme, Model model) {
        filme.setId(listaFilmes.size() + 1);
        listaFilmes.add(filme);
        model.addAttribute("filme", filme);
        return "redirect:/avaliar";
    }

    @GetMapping("/avaliar")
    public String exibirAvaliar(Model model) {
        model.addAttribute("listaFilmes", filmeService.listarTodosFilmes());
        return "avaliar";
    }

    @GetMapping("/avaliarFilme")
    public String exibirFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        filme filmeEncontrado = new filme();
        for (filme f : listaFilmes) {
            if (f.getId() == idFilme) {
                filmeEncontrado = f;
                break;
            }
        }
        List<Avaliacao> avaliacaoEncontrada = new ArrayList<>();
        for (Avaliacao a : listaAvaliacoes) {
            if (a.getFilme().getId() == idFilme) {
                avaliacaoEncontrada.add(a);
                System.out.println(a.getFilme().getTitulo());
                System.out.println(a.getAnalise());
            }
        }
        model.addAttribute("filme", filmeEncontrado);
        model.addAttribute("avaliacoes", avaliacaoEncontrada);
        model.addAttribute("avaliacao", new Avaliacao());
        return "filme";
    }

    @PostMapping("/guardar-avaliacao")
    public String processarFormularioFilme(Model model, @ModelAttribute Avaliacao avaliacao, @ModelAttribute filme filme, @RequestParam("filmeId") int filmeId) {
        filme filmeAssociado = null;
        for (filme f : listaFilmes) {
            if (f.getId() == filmeId) {
                filmeAssociado = f;
                break;
            }
        }

        if (filmeAssociado != null) {
            avaliacao.setId(listaAvaliacoes.size() + 1);
            avaliacao.setFilme(filmeAssociado);
            listaAvaliacoes.add(avaliacao);
        }

        return "redirect:/avaliarFilme?id=" + filmeId;
    }
}
