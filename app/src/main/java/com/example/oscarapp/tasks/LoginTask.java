package com.example.oscarapp.tasks;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        String stringURL = strings[0];
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer buffer = null;

        try {
            URL url = new URL(stringURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader  = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String line = "";
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (MalformedURLException e) {
            System.out.println("Primeira excecao:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Segunda excecao:" + e.getMessage());
        }

        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        System.out.println("Resposta: " + response);
        // O que deseja fazer com o retorno da doInBackground
    }
}