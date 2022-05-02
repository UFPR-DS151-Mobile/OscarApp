package com.example.oscarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oscarapp.activity.ConfirmarVoto;
import com.example.oscarapp.tasks.LoginTask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String email, senha;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {
        EditText inputEmail = findViewById(R.id.inputLoginEmail);
        EditText inputSenha = findViewById(R.id.inputLoginSenha);

        this.email = inputEmail.getText().toString();
        this.senha = inputSenha.getText().toString();*/

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Insira um usuario e senha!", Toast.LENGTH_SHORT).show();
            return;
        }
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