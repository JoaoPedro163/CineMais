package com.cinemais.cinemais.model;

public class Avaliacao {
    private int id;
    private String analise;
    private int nota;
    private filme filme;
    
    public Avaliacao(){
    }
    
    public Avaliacao(int id,filme filme ,String analise, int nota){
        this.id = id;
        this.analise = analise;
        this.nota = nota;
        this.filme = filme;
    }

    public filme getFilme() {
        return filme;
    }

    public int getId() {
        return id;
    }

    public String getAnalise() {
        return analise;
    }

    public int getNota() {
        return nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public void setFilme(filme filme) {
        this.filme = filme;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
