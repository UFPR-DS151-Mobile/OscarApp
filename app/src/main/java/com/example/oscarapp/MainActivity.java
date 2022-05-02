package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarapp.activity.ConfirmarVoto;
import com.example.oscarapp.activity.DetalheItemActivity;
import com.example.oscarapp.adapter.AdapterFilme;
import com.example.oscarapp.conexao.RetrofitConfig;
import com.example.oscarapp.models.FilmeModel;
import com.example.oscarapp.models.RecyclerItemClickListener;
import com.example.oscarapp.models.UserModel;
import com.example.oscarapp.tasks.LoginTask;
import com.google.gson.JsonParser;
import com.example.oscarapp.tasks.InitialActivity;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private String email, senha;

    private TextView output;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.output = findViewById(R.id.textViewOutput);
    }

    public void Login(View view) {
        EditText inputEmail = findViewById(R.id.inputLoginEmail);
        EditText inputSenha = findViewById(R.id.inputLoginSenha);

        this.email = inputEmail.getText().toString();
        this.senha = inputSenha.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Insira um usuario e senha!", Toast.LENGTH_SHORT).show();
            return;
        }
        Retrofit r = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitConfig interfaceAPI = r.create(RetrofitConfig.class);

//        UserModel user = new UserModel(this.email, this.senha);

        Call<Object> call = interfaceAPI.login(this.email, this.senha);

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    try {
//                        String jsonString = response.body().toString();
//                        System.out.println("entrou try catch: "+jsonString);
//                        JSONObject json = response.body();
//                        System.out.println("Json: "+response.body());
                        Intent menuTeste = new Intent(getApplicationContext(), MenuActivity.class);
//                        Bundle params = new Bundle();
//                        params.putString("nome", json.getJSONObject("user").getString("name"));
//                        params.putString("token", json.getString("token"));
//                        menuTeste.putExtras(params);
                        startActivity(menuTeste);
                    } catch (Exception e) {
                        System.out.println("Erro no response positivo: "+e.getMessage());
                    }
                } else {
//                    if (response.code() == 401) {
                        try {
                            JSONObject json = new JSONObject(response.errorBody().string());
                            output.setVisibility(View.VISIBLE);
                            output.setText(json.getString("message"));
                        } catch (Exception e) {
                            System.out.println("Erro no response negativo: "+e.getMessage());
                        }
//                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                System.out.println("Response failure: "+t.getMessage());
//                System.out.println("Resposta errada do login: "+ );
            }
        });
        Intent telaInicial = new Intent(getApplicationContext(), InitialActivity.class);
        startActivity(telaInicial);

          /* retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/01310100/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
//        String url = "http://localhost:8000/api/login";
//        LoginTask task =  new LoginTask(); // RequestTask vai extender de AsyncTask
//        task.execute(url); // Parametro que vai pro doInBackground
    }
}