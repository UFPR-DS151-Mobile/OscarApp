package com.example.oscarapp.models;

public class Filme {
    private String nome, genero, imagem;

    public Filme() {
    }

    public Filme(String nome, String genero, String imagem) {
        this.nome = nome;
        this.genero = genero;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
