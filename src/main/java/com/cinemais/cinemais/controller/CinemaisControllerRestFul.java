package com.cinemais.cinemais.controller;

import com.cinemais.cinemais.model.Avaliacao;
import com.cinemais.cinemais.model.filme;
import com.cinemais.cinemais.service.AvaliacoesService;
import com.cinemais.cinemais.service.FilmesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Classe Controller da API
@RestController
@RequestMapping("/cinemais")
public class CinemaisControllerRestFul {

    @Autowired
    private FilmesService filmeService;

    @Autowired
    private AvaliacoesService avaliacaoService;

    //Listar todos os filmes
    @GetMapping("/listar")
    public ResponseEntity<List> getAllFilmes() {
        List<filme> listaFilmes = filmeService.listarTodosFilmes();
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    //Listar filmes pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<filme> getFilmeId(@PathVariable Integer id) {
        filme f = filmeService.getFilmeId(id);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    //Cadastrar filme
    @PostMapping("")
    public ResponseEntity<filme> adicionarFilme(@RequestBody filme filme) {
        var filmeNovo = filmeService.criarFilme(filme);
        return new ResponseEntity<>(filmeNovo, HttpStatus.CREATED);
    }

    //Listar filme que contenham a variavel titulo
    @GetMapping("/{titulo}")
    public ResponseEntity<List<filme>> getFilmesTitulo(@PathVariable String titulo) {
        List<filme> listaFilmes = filmeService.listarFilmesTitulo(titulo);
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    //Alterar dados do filme já cadastrado
    @PutMapping("/{id}")
    public ResponseEntity<filme> alterarFilme(@PathVariable Integer id, @RequestBody filme filmeAtualizado) {
        filme f = filmeService.atualizarFilme(filmeAtualizado, id);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    //Excluir filmes de acordo com o ID passado
    @DeleteMapping("/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Daqui para baixo são requisições das Avaliações

    //Listar todas as avaliações
    @GetMapping("/avaliacao")
    public ResponseEntity<List> listarAvaliacoes() {
        List<Avaliacao> listaAvaliacoes = avaliacaoService.getAllFilmes();
        return new ResponseEntity<>(listaAvaliacoes, HttpStatus.OK);
    }

    //Listar avaliação com o Id correspondente
    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<Avaliacao> listarAvaliacaoId(@PathVariable Integer id) {
        Avaliacao aval = avaliacaoService.getAvaliacaoId(id);
        return new ResponseEntity<>(aval, HttpStatus.OK);
    }

    //Adiciona avaliação
    @PostMapping("/avaliacao")
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        var aval = avaliacaoService.addAvaliacao(avaliacao);
        return new ResponseEntity<>(aval, HttpStatus.CREATED);
    }

    //Lista avaliações que contenha a variavel titulo
    @GetMapping("/avaliacao/{titulo}")
    public ResponseEntity<List<Avaliacao>> listarAvaliacaoTitulo(@PathVariable String titulo) {
        List<Avaliacao> listaAvaliacoes = avaliacaoService.getFilmeTitulo(titulo);
        return new ResponseEntity<>(listaAvaliacoes, HttpStatus.OK);
    }

    //Edita a avaliação do ID correspondente
    @PutMapping("/avaliacao/{id}")
    public ResponseEntity<Avaliacao> updateAvaliacao(@PathVariable Integer id, @RequestBody Avaliacao avaliacaoAtualizada) {
        Avaliacao aval = avaliacaoService.updateAvaliacao(id, avaliacaoAtualizada);
        return new ResponseEntity<>(aval, HttpStatus.OK);
    }

    //Exclui a avaliação do ID correspondente
    @DeleteMapping("/avaliacao/{id}")
    public ResponseEntity excluirAvaliacao(@PathVariable Integer id) {
        avaliacaoService.deletarAvaliacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
