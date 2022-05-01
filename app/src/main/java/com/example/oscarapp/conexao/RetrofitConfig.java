package com.example.oscarapp.conexao;

import com.example.oscarapp.activity.DiretorActivity;
import com.example.oscarapp.models.DiretorModel;
import com.example.oscarapp.models.FilmeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitConfig {

    @GET("ufpr/filme")
    Call<List<FilmeModel>> getFilme();
    @GET("ufpr/diretor")
    Call<List<DiretorModel>> getDiretor();
}
