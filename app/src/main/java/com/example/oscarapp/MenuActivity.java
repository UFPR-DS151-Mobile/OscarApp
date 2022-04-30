package com.example.oscarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.oscarapp.activity.ConfirmarVoto;
import com.example.oscarapp.activity.Diretor;
import com.example.oscarapp.activity.Filmes;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.votarFilme:
                Intent intentFilmes = new Intent(getApplicationContext(), Filmes.class);
                startActivity(intentFilmes);
                break;

            case R.id.votarDiretor:
                Intent intentDiretor = new Intent(getApplicationContext(), Diretor.class);
                startActivity(intentDiretor);
                break;

            case R.id.confirmarVoto:
                Intent intentConfirmarVoto = new Intent(getApplicationContext(), ConfirmarVoto.class);
                startActivity(intentConfirmarVoto);
                break;

            case R.id.logout:
                finish();
                System.exit(0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}