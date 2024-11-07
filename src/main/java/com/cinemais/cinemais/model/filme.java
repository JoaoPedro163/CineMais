package com.cinemais.cinemais.model;

import java.time.LocalDate;

public class filme {

    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private LocalDate anoLancamento;

    public filme(){
        
    }
    
    public filme(int id, String titulo,String sinopse, String genero, LocalDate anoLancamento){
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
