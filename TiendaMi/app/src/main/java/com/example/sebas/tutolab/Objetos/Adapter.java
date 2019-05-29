package com.example.sebas.tutolab.Objetos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebas.tutolab.R;

import java.util.List;

/**
 * Created by sebas on 31/05/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.TutoresviewHolder> {

    List<Tutores> tutores;

    public Adapter(List<Tutores> tutores) {
        this.tutores = tutores;
    }


    @Override
    public TutoresviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        TutoresviewHolder holder = new TutoresviewHolder(v);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull TutoresviewHolder holder, int position) {
        Tutores tutor = tutores.get(position);
        holder.textViewNombre.setText(tutor.getNombre());
        holder.textViewMateria.setText(tutor.getMateria());
        holder.textViewHorario.setText(tutor.getHorario());

    }

    @Override
    public int getItemCount() {
        return tutores.size();

    }

    public static class TutoresviewHolder extends RecyclerView.ViewHolder {

      TextView textViewNombre,textViewMateria,textViewHorario;
        public TutoresviewHolder(View itemView) {
            super(itemView);
            textViewNombre= (TextView) itemView.findViewById(R.id.textview_nombre);
            textViewMateria= (TextView) itemView.findViewById(R.id.textview_materia);
            textViewHorario= (TextView) itemView.findViewById(R.id.textview_horario);

        }
    }

}
