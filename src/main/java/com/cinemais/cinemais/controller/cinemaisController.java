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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class cinemaisController {

    private List<filme> listaFilmes = new ArrayList();

    private void inicializarFilmes() {
        listaFilmes.add(new filme(1, "O Senhor dos Anéis: A Sociedade do Anel", "Frodo e seus amigos tentam destruir o Anel para salvar a Terra-média.", "Aventura/Fantasia", LocalDate.of(2001, 12, 19)));
        listaFilmes.add(new filme(2, "Matrix", "Um hacker descobre que a realidade em que vive é uma ilusão.", "Ficção Científica", LocalDate.of(1999, 3, 31)));
        listaFilmes.add(new filme(3, "Titanic", "Uma história de amor a bordo do navio Titanic, enquanto ele afunda.", "Drama/Romance", LocalDate.of(1997, 12, 19)));
        listaFilmes.add(new filme(4, "O Poderoso Chefão", "A história de uma família mafiosa e a luta pelo poder.", "Crime/Drama", LocalDate.of(1972, 3, 24)));
        listaFilmes.add(new filme(5, "Vingadores: Ultimato", "Os Vingadores tentam derrotar Thanos e salvar o universo.", "Ação/Fantasia", LocalDate.of(2019, 4, 26)));
        listaFilmes.add(new filme(6, "Gladiador", "Um general romano busca vingança após ser traído e ver sua família morta.", "Ação/Drama", LocalDate.of(2000, 5, 5)));
        listaFilmes.add(new filme(7, "Star Wars: O Império Contra-Ataca", "Os rebeldes enfrentam o império, enquanto Luke Skywalker busca treinar como Jedi.", "Ficção Científica/Aventura", LocalDate.of(1980, 5, 17)));
        listaFilmes.add(new filme(8, "Jurassic Park", "Cientistas clonam dinossauros, mas as coisas saem do controle.", "Aventura/Ficção Científica", LocalDate.of(1993, 6, 11)));
        listaFilmes.add(new filme(9, "Forrest Gump", "A história de Forrest, um homem com baixo QI, que viveu grandes momentos da história dos EUA.", "Drama/Romance", LocalDate.of(1994, 7, 6)));
        listaFilmes.add(new filme(10, "Harry Potter e a Pedra Filosofal", "Um garoto descobre ser um bruxo e começa sua jornada na escola de magia de Hogwarts.", "Fantasia/Aventura", LocalDate.of(2001, 11, 10)));
        listaFilmes.add(new filme(11, "A Origem", "Um ladrão especialista em extrair segredos via sonhos é contratado para uma missão de infiltração.", "Ficção Científica/Thriller", LocalDate.of(2010, 7, 16)));
        listaFilmes.add(new filme(12, "O Rei Leão", "Simba, um jovem leão, assume seu lugar como rei da savana após a morte de seu pai.", "Animação/Aventura", LocalDate.of(1994, 6, 15)));
        listaFilmes.add(new filme(13, "Pulp Fiction", "A história é dividida em várias tramas entrelaçadas no mundo do crime.", "Crime/Drama", LocalDate.of(1994, 10, 14)));
        listaFilmes.add(new filme(14, "O Grande Lebowski", "O 'Dude' é arrastado para um esquema de sequestro e confusão no Los Angeles dos anos 90.", "Comédia/Crime", LocalDate.of(1998, 3, 6)));
        listaFilmes.add(new filme(15, "Coringa", "Arthur Fleck, um homem marginalizado, se transforma no infame vilão Coringa.", "Drama/Crime", LocalDate.of(2019, 10, 4)));
    }
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
        listaFilmes.add(filme);
        model.addAttribute("filme", filme);
        return "redirect:/avaliar";
    }

    @GetMapping("/avaliar")
    public String exibirAvaliar(Model model) {
        inicializarFilmes();
        model.addAttribute("listaFilmes", listaFilmes);
        return "avaliar";
    }
    
    @GetMapping("/avaliarFilme")
    public String exibirFilme(Model model,@RequestParam String id){
        Integer idFilme = Integer.parseInt(id);
        filme filmeEncontrado = new filme();
        for(filme f : listaFilmes){
            if(f.getId() == idFilme){
                filmeEncontrado = f;
                break;
            }
        }
        System.out.println(filmeEncontrado.getTitulo());
        model.addAttribute("filme", filmeEncontrado);
        return "filme";
    }
}
