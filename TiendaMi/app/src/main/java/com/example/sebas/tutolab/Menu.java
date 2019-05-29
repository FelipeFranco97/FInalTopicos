package com.example.sebas.tutolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button siguiente,siguiente2,siguiente3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        siguiente = (Button)findViewById(R.id.button2);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(Menu.this, Materias.class);
                startActivity(siguiente);
            }
        });

        siguiente2 = (Button)findViewById(R.id.button3);
        siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente2 = new Intent(Menu.this, Historial.class);
                startActivity(siguiente2);
            }
        });

        siguiente3 = (Button)findViewById(R.id.button4);
        siguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente3 = new Intent(Menu.this, MainActivity.class);
                startActivity(siguiente3);
            }
        });
    }
}
