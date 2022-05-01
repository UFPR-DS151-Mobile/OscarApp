package com.example.oscarapp.models;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class FilmeModel {
    private String nome, genero, foto;
    ImageView imagem;

    public FilmeModel() {
    }

    public FilmeModel(String nome, String genero, String foto, ImageView imagem) {
        this.nome = nome;
        this.genero = genero;
        this.imagem = imagem;
        this.foto = foto;
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

    public String getFoto(){
        return foto;
    }
    public void setFoto(String foto){
        this.foto = foto;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}