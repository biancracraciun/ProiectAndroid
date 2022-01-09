package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
 Button b1,b2,b3,b4,b5,b6,b7,b8, b9, b0, bs1, bs2;
  String pass="";
  TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)  findViewById(R.id.button2);
        b2= (Button)  findViewById(R.id.button);
        b3= (Button)  findViewById(R.id.button11);
        b4= (Button)  findViewById(R.id.button12);
        b5= (Button)  findViewById(R.id.button13);
        b6= (Button)  findViewById(R.id.button14);
        b7= (Button)  findViewById(R.id.button15);
        b8= (Button)  findViewById(R.id.button16);
        b9= (Button)  findViewById(R.id.button17);
        b0= (Button)  findViewById(R.id.button19);
        bs1= (Button)  findViewById(R.id.button20);
        bs2= (Button)  findViewById(R.id.button21);

         tx= (TextView) findViewById(R.id.textView2);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                pass+=1;
              tx.setText(pass);
              check();
             }
         });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=2;
                tx.setText(pass);
                 check();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=3;
                tx.setText(pass);
                 check();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=4;
                tx.setText(pass);
                 check();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=5;
                tx.setText(pass);
                 check();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=6;
                tx.setText(pass);
                 check();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=7;
                tx.setText(pass);
                 check();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=8;
                tx.setText(pass);
                 check();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=9;
                tx.setText(pass);
                 check();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+=0;
                tx.setText(pass);
                 check();
            }
        });
        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+="#";
                tx.setText(pass);
                check();
            }
        });
        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass+="*";
                tx.setText(pass);
              check();
            }
        });

    }
     public  void check() {
         if (pass.length() == 4) {
             if (pass.equals("1234")) {
                 Intent i = new Intent(MainActivity.this, MainActivity2.class);
                 startActivity(i);
                 tx.setText("");


             } else {

                 Toast toast = Toast.makeText(getApplicationContext(), "Pin Incorect", Toast.LENGTH_SHORT);
                 toast.show();
                 pass = "";
                 tx.setText("");
             }
         }
     }
}