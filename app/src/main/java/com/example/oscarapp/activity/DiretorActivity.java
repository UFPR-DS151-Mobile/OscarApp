package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.oscarapp.MenuActivity;
import com.example.oscarapp.R;
import com.example.oscarapp.Voto;
import com.example.oscarapp.conexao.RetrofitConfig;
import com.example.oscarapp.models.DiretorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiretorActivity extends AppCompatActivity {
     DiretorModel diretor;
     List<DiretorModel> diretores;

      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_diretor);
            this.createDiretor();

        }


        public void createDiretor() {
            Retrofit r = new Retrofit.Builder()
                    .baseUrl("http://wecodecorp.com.br/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RetrofitConfig interfaceAPI = r.create(RetrofitConfig.class);

            Call<List<DiretorModel>> call = interfaceAPI.getDiretor();

            call.enqueue(new Callback<List<DiretorModel>>() {
                @Override
                public void onResponse(Call<List<DiretorModel>> call, Response<List<DiretorModel>> response) {
                    RadioGroup radioGroup = findViewById(R.id.radioDiretor);

                    diretores = response.body();
                    int i = 0;
                    for (DiretorModel diretor : diretores) {
                            RadioButton radioButton = new RadioButton(DiretorActivity.this);
                            radioButton.setId(i);
                            radioButton.setText(diretor.getNome());
                            radioGroup.addView(radioButton);
                            i++;
                        }
                    }

                @Override
                public void onFailure(Call<List<DiretorModel>> call, Throwable t) {

                }
            });

        }
    public void votarDiretor(View view){
        try {
            RadioGroup radioGroup = findViewById(R.id.radioDiretor);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            System.out.println("Id do botao: " + selectedId);
            diretor = diretores.get(selectedId);

            final Voto voto = (Voto) getApplicationContext();
            voto.setDiretor(diretor);

            Intent menu = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(menu);
        } catch(Exception e) {
            Toast.makeText(this, "Escolha uma opção", Toast.LENGTH_SHORT).show();
        }
    }

}