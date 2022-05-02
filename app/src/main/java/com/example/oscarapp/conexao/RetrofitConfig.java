package com.example.oscarapp.conexao;

import com.example.oscarapp.models.DiretorModel;
import com.example.oscarapp.models.FilmeModel;
import com.example.oscarapp.models.UserModel;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitConfig {

    @GET("ufpr/filme")
    Call<List<FilmeModel>> getFilme();
    @GET("ufpr/diretor")
    Call<List<DiretorModel>> getDiretor();
//    @POST("login")
//    Call<UserModel> login(@Body UserModel user);

    @FormUrlEncoded
    @POST("login")
    Call<Object> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
