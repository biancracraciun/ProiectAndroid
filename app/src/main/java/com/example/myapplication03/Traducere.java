package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Traducere extends AppCompatActivity {
    JSONObject json;
    TextView txtView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traducere);
        button = (Button) findViewById(R.id.button);
        txtView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncCaller().execute();
            }
        });
    }
        private class AsyncCaller extends AsyncTask<Void, Void, String>
        {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
//this method will be running on UI thread
            }
            @Override
            protected String doInBackground(Void... params) {
//this method will be running on background thread so don't update UI frome here
//do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here
                Log.d("###","starting test ...");
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(mediaType,
                        "text="+txtView.getText()+"&tl=en&sl=ro");
                Request request = new Request.Builder()
                        .url("https://google-translate20.p.rapidapi.com/translate")
                        .post(body)
                        .addHeader("content-type", "application/x-www-form-urlencoded")
                        .addHeader("x-rapidapi-host", "google-translate20.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "cf26dd3c73mshdd5e0ce40dc73f9p173d45jsn8d4ef6944414")
                        .build();
                Response response = null;
                String r=null;
                try {
                    response = client.newCall(request).execute();
                    r = response.body().string();

                    json = new JSONObject(r);
                    return json.getJSONObject("data").getString("translation");
                } catch (IOException | JSONException e ) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                txtView.setText(result); //this method will be running on UI thread
            }
        }
    }
