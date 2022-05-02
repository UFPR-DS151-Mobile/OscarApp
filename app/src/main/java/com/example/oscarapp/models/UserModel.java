package com.example.oscarapp.models;

public class UserModel {

    private String nome, email, senha, token;

    public UserModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public void setNome(String s){
        this.nome = s;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String s){ this.email = s; }

    public String getSenha() { return senha; }
    public void setSenha(String s){ this.senha = s; }

    public String getToken() { return token; }
    public void setToken(String s){ this.token = s; }
}
