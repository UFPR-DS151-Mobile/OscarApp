package com.example.oscarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.oscarapp.activity.ConfirmarVoto;
import com.example.oscarapp.activity.DiretorActivity;
import com.example.oscarapp.activity.FilmesActivity;

public class MenuActivity extends AppCompatActivity {

    String token;
    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
//        Bundle params = it.getExtras();
//        this.nome.setText(params.getString("nome"));
//        this.token = params.getString("token");
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
                Intent intentFilmes = new Intent(getApplicationContext(), FilmesActivity.class);
                startActivity(intentFilmes);
                break;
            case R.id.votarDiretor:
                Intent intentDiretor = new Intent(getApplicationContext(), DiretorActivity.class);
                startActivity(intentDiretor);
                break;
            case R.id.confirmarVoto:
                Intent intentConfirmarVoto = new Intent(getApplicationContext(), ConfirmarVoto.class);
                startActivity(intentConfirmarVoto);
                break;
            case R.id.logout:
                Voto voto = (Voto) getApplicationContext();
                voto.setDiretor(null);
                voto.setFilme(null);
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}