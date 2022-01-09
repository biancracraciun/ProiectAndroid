package com.example.myapplication03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calcul1 extends AppCompatActivity {
    private TextView twResult;
    private EditText etNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul1);
        etNumber=findViewById(R.id.edit_text_number);

        Button buttonOpenA2=findViewById(R.id.button_open_activity);
        buttonOpenA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNumber.getText().toString().equals(""))
                {
                    Toast.makeText(Calcul1.this, "Please write a number", Toast.LENGTH_SHORT).show();

                }else
                {
                    int number=Integer.parseInt(etNumber.getText().toString());

                    Intent intent= new Intent(Calcul1.this,Calcul2.class);
                    intent.putExtra("number", number);
                    startActivityForResult(intent,1);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                int result= data.getIntExtra("result", 0);
                etNumber.setText(""+result);

            }
            if(resultCode== RESULT_CANCELED)
            {
                etNumber.setText("ERROR");
            }
        }
    }
}