package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    TextView textIMC;
    TextView textResulado;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();

        double imc = intent.getDoubleExtra("IMC",1);

        textIMC = findViewById(R.id.text_imc);
        textResulado = findViewById(R.id.text_resultado);
        voltar = findViewById(R.id.button_voltar);

        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        String textoIMC = "O seu imc é " + df.format(imc);

        textIMC.setText(textoIMC);
        textResulado.setText(resultado(imc));

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ResultadoActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }

    private String resultado(double imc) {

        if(imc<18) return "você está abaixo do peso";
        else if(imc < 25) return "seu peso está normal";
        else if(imc < 30) return "Você está com sobrepeso";
        else if(imc < 35) return "Você está com obesidade grau 1";
        else if(imc < 40) return "Você está com obesidade grau 2";
        else return "Você está com obesidade grau 3";
    }
}
