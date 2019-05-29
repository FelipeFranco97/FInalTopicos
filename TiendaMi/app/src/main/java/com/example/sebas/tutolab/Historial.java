package com.example.sebas.tutolab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sebas.tutolab.Objetos.Adapter;
import com.example.sebas.tutolab.Objetos.FirebaseReferences;
import com.example.sebas.tutolab.Objetos.Tutores;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity {
    RecyclerView rv;

    List<Tutores> tutores;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        rv = (RecyclerView) findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        tutores = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapter = new Adapter(tutores);
        rv.setAdapter(adapter);

        database.getReference(FirebaseReferences.REFERENCIA2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                tutores.removeAll(tutores);
                for (DataSnapshot snapshot:
                     dataSnapshot.getChildren())
                {
                    Tutores tutores2 = snapshot.getValue(Tutores.class);
                    tutores.add(tutores2);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
