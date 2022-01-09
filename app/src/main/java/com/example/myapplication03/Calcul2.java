package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calcul2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul2);
        setTitle("Activity 2");
        Intent intent= getIntent();
        int number=intent.getIntExtra("number", 0);

        TextView tVNumber=  findViewById(R.id.text_view_number);
        tVNumber.setText("Number:"+number);
        Button buttonA =findViewById(R.id.button_add);
        Button buttonM =findViewById(R.id.button_multiply);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result= number+2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result= number*2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}