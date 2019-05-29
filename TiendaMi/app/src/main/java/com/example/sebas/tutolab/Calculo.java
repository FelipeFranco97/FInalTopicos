package com.example.sebas.tutolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sebas.tutolab.Objetos.FirebaseReferences;
import com.example.sebas.tutolab.Objetos.Tutores;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Calculo extends AppCompatActivity {
    Button Caldo,Pan,Fabuloso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        Caldo =findViewById(R.id.button11);
        Pan =(Button) findViewById(R.id.button13);
        Fabuloso =findViewById(R.id.button12);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tutorialRef = database.getReference(FirebaseReferences.REFERENCIA2);
        Caldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Caldo Magi","500","Santuario");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Caldo Magi en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Calculo.this, Menu.class);
                startActivity(siguiente);
            }


        });
        Pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Pan Bimbo","3.000","Santuario");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Pan Bimbo en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Calculo.this, Menu.class);
                startActivity(siguiente);

            }
        });

        Fabuloso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Fabuloso","6.000","Santuario");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Pan Bimbo en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Calculo.this, Menu.class);
                startActivity(siguiente);



            }
        });
    }
}
