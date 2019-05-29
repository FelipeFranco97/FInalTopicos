package com.example.sebas.tutolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Materias extends AppCompatActivity {
    Button siguiente,siguiente2,siguiente3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        siguiente = (Button)findViewById(R.id.button8);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(Materias.this, Algoritmos.class);
                startActivity(siguiente);
            }
        });
        siguiente2= (Button)findViewById(R.id.button9);
        siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente2 = new Intent(Materias.this, Calculo.class);
                startActivity(siguiente2);
            }
        });

        siguiente3 = (Button)findViewById(R.id.button10);
        siguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente3 = new Intent(Materias.this, Geometria.class);
                startActivity(siguiente3);
            }
        });
    }
}
