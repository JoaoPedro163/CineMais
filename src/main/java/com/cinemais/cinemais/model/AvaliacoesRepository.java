package com.cinemais.cinemais.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacao, Integer>{
    
    //Busca avaliação de acordo com o ID o filme
    Avaliacao findByFilme_id(Integer id);
    
    //Busca avaliações de acordo com o Titulo do filme
    List<Avaliacao> findByFilmeTitulo(String titulo);
    
    //Busca avaliações que contenham a o valor da variavel passada
    List<Avaliacao> findByFilmeTituloContaining(String titulo);
}
