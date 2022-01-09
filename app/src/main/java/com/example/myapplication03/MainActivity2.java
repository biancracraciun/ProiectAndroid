package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
     ArrayList<String> dictionar= new ArrayList<>();
     ImageButton cautare;
     EditText cuvant;
     Button traducere, list, gallery,calcul,fib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         dictionar.add("mar");
        dictionar.add("casa");
        dictionar.add("pahar");

        cuvant=(EditText) findViewById(R.id.edit);
        cautare=(ImageButton) findViewById(R.id.imageButton);
        traducere=(Button) findViewById(R.id.button3);
        calcul=(Button) findViewById(R.id.button6);
        gallery=(Button) findViewById(R.id.button4);
        list=(Button) findViewById(R.id.button5);
       fib=(Button) findViewById(R.id.button7);


         cautare.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String cuvantCautat=cuvant.getText().toString();
                 Boolean exista= false;

                  for( String c: dictionar)
                  {
                      if(c.equals(cuvantCautat))
                      {
                           exista= true;
                          Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                          i.putExtra("message", cuvantCautat);
                          startActivity(i);

                      }

                  }
             }
         });
          traducere.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i = new Intent(MainActivity2.this, Traducere.class);
                  startActivity(i);

              }
          });
      calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,Calcul1.class);
                startActivity(i);

            }
        });
      gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,Gallery.class);
                startActivity(i);

            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,List.class);
                startActivity(i);

            }
        });
    fib.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity2.this,MainActivity4.class);
            startActivity(i);
        }
    });


    }
}