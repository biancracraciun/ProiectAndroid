package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
     TextView cuv, definitie;
     ImageView imagine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         cuv=(TextView) findViewById(R.id.textView);
         definitie=(TextView) findViewById(R.id.textView3);
         Intent i= getIntent();
         String mess=i.getStringExtra("message");
         cuv.setText(mess);
         String iaCuvant=cuv.getText().toString();
         imagine=(ImageView)  findViewById(R.id.imageView);
         switch (iaCuvant)
         {
            case "mar":
               imagine.setImageResource(R.drawable.mar);
              definitie.setText("Pom din familia rozaceelor, cu frunze mari, ovale, păroase, cu flori albe-trandafirii și fructe globuloase, comestibile, bogate în vitamine");
              break;
             case "casa":
                 imagine.setImageResource(R.drawable.casa);
                 definitie.setText("Clădire care servește drept locuință. ◊ Loc. adj. De casă = făcut în casă1. ◊ Expr. (A avea) o casă de copii = (a avea) copii mulți. A-i fi cuiva casa casă și masa masă = a duce o viață ordonată, normală, liniștită. A nu avea (nici) casă, nici (masă) = a duce o viață neregulată, plină de griji, de frământări.");
                  break;
             case "pahar":
                 imagine.setImageResource(R.drawable.pa);
                 definitie.setText("as de sticlă, de metal, de material plastic etc., de diferite forme ori mărimi, din care se bea apă sau alte lichide; p. ext. conținutul unui asemenea vas; vasul împreună cu conținutul. ◊ Pahar dulce (sau de dar) = pahar de vin sau de țuică (îndulcit cu miere), care se oferă oaspeților la nuntă și pentru care aceștia dăruiesc mirilor bani. ◊ Loc. adj. Bun de pahar = care obișnuiește să bea băuturi alcoolice; care rezistă la băutură. ◊ Loc. adv. La un pahar de (sau cu) vin = în timp ce bea (împreună cu alții), la băutură; p. ext. la chef, la petrecere. ◊ Expr. A fi sau a ține etc. (ceva) (ca un) pahar = a fi sau a ține foarte curat. ");

          }


    }
}