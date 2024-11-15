package com.cinemais.cinemais.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<filme, Integer>{
    
   //Busca filmes de acordo com o titulo passado
   filme findByTitulo(String titulo);
   
   //Busca filmes que contenham ou o titulo ou o genero passado
   List<filme> findByTituloOrGenero(String titulo, String genero);
   
   //Busca filmes que  o titulo comece com o valor da variável passada
   List<filme> findByTituloStartingWith(String titulo);
   
   //Busca titulo que termine com o valor da variavel passada
   List<filme> findByTituloEndingWith(String titulo);
   
   //Busca filmes que terminem com o valor da variável passsada
   List<filme> findByTituloContaining(String titulo);
   
   //Organiza os filmes em ordem crescente
   List<filme> findByOrderByTituloAsc();
   
   //Organiza os filmes em ordem decrescente
   List<filme> findByOrderByTituloDesc();
   
   //Organiza os filmes de acordo com o Ano de Lancamento em order crescente
   List<filme> findByOrderByAnoLancamentoAsc();
}
