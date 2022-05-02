package com.example.oscarapp;

import android.app.Application;

import com.example.oscarapp.models.DiretorModel;
import com.example.oscarapp.models.FilmeModel;

public class Voto extends Application {

    private FilmeModel filme;
    private DiretorModel diretor;

    public FilmeModel getFilme() {

        return this.filme;
    }

    public void setFilme(FilmeModel filme) {

        this.filme = filme;

    }

    public DiretorModel getDiretor() {

        return this.diretor;
    }

    public void setDiretor(DiretorModel diretor) {

        this.diretor = diretor;
    }
}
