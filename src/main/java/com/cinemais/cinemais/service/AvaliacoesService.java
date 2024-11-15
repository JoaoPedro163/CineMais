package com.cinemais.cinemais.service;

import com.cinemais.cinemais.model.Avaliacao;
import com.cinemais.cinemais.model.AvaliacoesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacoesService {
    
    @Autowired
    private AvaliacoesRepository avaliacaoRepository;
    
    //Busca uma avaliação de acordo com o ID e retorna ela
    public Avaliacao getAvaliacaoId(Integer id){
       return avaliacaoRepository.findById(id).orElse(null);
    }
    
    //Busca avaliações que tenham o titulo passado como parâmetro e retorna em uma lista
    public List<Avaliacao> getFilmeTitulo(String titulo){
        return avaliacaoRepository.findByFilmeTitulo(titulo);
    }
    
    //Busca todas as avaliações e retorna uma lista com elas
    public List<Avaliacao> getAllFilmes(){
        return avaliacaoRepository.findAll();
    }
    
    //Busca todas as avaliações de filmes que tenham o valor da variavel passada
    public List<Avaliacao> getFilmeContainingTitulo(String titulo){
        return avaliacaoRepository.findByFilmeTituloContaining(titulo);
    }
    
    //Adiciona uma avaliação ao banco de dados e retorna o objeto dela
    public Avaliacao addAvaliacao(Avaliacao avaliacao){
        avaliacao.setId(null);
        avaliacaoRepository.save(avaliacao);
        return avaliacao;
    }
    
    //Edita algum atributo da avaliação de acordo com o ID e retorna o objeto dela
    public Avaliacao updateAvaliacao(Integer id, Avaliacao avaliacao){
        Avaliacao aval = getAvaliacaoId(id);
        aval.setAnalise(avaliacao.getAnalise());
        aval.setNota(avaliacao.getNota());
        aval.setFilme(avaliacao.getFilme());
        
        avaliacaoRepository.save(aval);
        
        return aval;
    }
    
    //Deleta a avaliação do banco de dados de acordo com o id
    public void deletarAvaliacao(Integer id){
        avaliacaoRepository.deleteById(id);
    }
}
