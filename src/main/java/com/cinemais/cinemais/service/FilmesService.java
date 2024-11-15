package com.cinemais.cinemais.service;

import com.cinemais.cinemais.exception.ResourceNotFoundException;
import com.cinemais.cinemais.model.FilmesRepository;
import com.cinemais.cinemais.model.filme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmesService {
    
    @Autowired
    FilmesRepository filmeRepository;
    
    //Adiciona um filme  ao banco de dados e retorna o objeto dele
    public filme criarFilme(filme filme){
        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }
    
    //Busca um filme pelo ID e retorna o obejto dele
    public filme getFilmeId(Integer id){
        return filmeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o filme " + id));
    }
    
    //Edita algum atributo do filme de acordo com o ID e retorna o objeto atualizado
    public filme atualizarFilme(filme filme, Integer id){
        filme f = getFilmeId(id);
        f.setTitulo(filme.getTitulo());
        f.setSinopse(filme.getSinopse());
        f.setGenero(filme.getGenero());
        f.setAnoLancamento(filme.getAnoLancamento());
        
        filmeRepository.save(f);
        
        return f;
    }
    
    //Busca todos os filmes que contenha o valor da variável passada e retorna uma lista com o resultado
    public List<filme> listarFilmesTitulo(String titulo){
        return filmeRepository.findByTituloContaining(titulo);
    }
    
    //Busca todos os filmes que tenham o titulo ou genero passado e retorna uma lista com o resultado
    public List<filme> listaFilmesTituloGenero(String titulo, String genero){
        return filmeRepository.findByTituloOrGenero(titulo, genero);
    }
    
    //Busca todos os filmes que o titulo comece com o valor da variável passada e retorna uma lista
    public List<filme> listaFilmesTituloStarting(String titulo){
        return filmeRepository.findByTituloStartingWith(titulo);
    }

    //Deleta um filme de acordo como ID e não tem nenhum retorno
    public void deletarFilme(Integer id){
        filme f = getFilmeId(id);
        filmeRepository.deleteById(f.getId());
    }
    
    //Busca todos os filmes cadastrados e retorna em uma lista
    public List<filme> listarTodosFilmes(){
        return filmeRepository.findAll();
    }
}
