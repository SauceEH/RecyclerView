package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*  creamos el adapter para manejar el recyclerView de alumnos
    hereda de RecyclerView.Adapter y de la clase interna AlumnoBasicViewHolder (que tenemos que crear)
 */
public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoBasicViewHolder>{

    // propiedades
    private ArrayList<Alumno> listaAlumnos;

    // para diferenciar items pares e impares
    private static final int EVEN = 0;
    private static final int ODD = 1;

    // Clase necesaria para adaptar los elementos de la lista a los elementos del RecyclerView
    public static class AlumnoBasicViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNombre;
        public TextView tvApellido;
        public TextView tvCiclo;
        public TextView tvCurso;

        // constructor para el holder, creando vistas (para layouts) y enviarles datos
        // (binding --> onBindViewHolder)
        public AlumnoBasicViewHolder (View itemView)
        {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvCiclo = itemView.findViewById(R.id.tvCiclo);
            tvCurso = itemView.findViewById(R.id.tvCurso);
        }
    }

    // CONSTRUCTOR DE ALUMNO ADAPTER
    public AlumnoAdapter(ArrayList <Alumno> listaAlumnos) { this.listaAlumnos = listaAlumnos;}

    // maneja el final de la lista
    @Override
    public int getItemCount() { return listaAlumnos.size();}


    // llamado cuando se necesita un viewholder, alimentando nuevos items cuando se necesitan
    @NonNull
    @Override
    public AlumnoBasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;

        // diferenciamos lineas pares e impares
        if (viewType == EVEN)
        {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemeven, parent, false);
        }

        else
        {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        }

        return new AlumnoBasicViewHolder(itemView);

    }

    //getting the type of item must be loaded
    @Override
    public int getItemViewType (int position){

        if (position%2==0){
            return EVEN;
        }else {
            return ODD;
        }
    }

    // refresca elementos en el recyclerView
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AlumnoBasicViewHolder holder, int position) {

        holder.tvNombre.setText(listaAlumnos.get(position).getNombre());
        holder.tvApellido.setText(listaAlumnos.get(position).getApellido());
        holder.tvCiclo.setText(listaAlumnos.get(position).getCiclo());
        holder.tvCurso.setText(Integer.toString(listaAlumnos.get(position).getCurso()));

    }




}
