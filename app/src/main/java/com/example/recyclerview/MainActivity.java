package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;

// antes de nada hay que importar (implementation 'androidx.recyclerview:recyclerview:1.1.0') en el gradle module.app

public class MainActivity extends AppCompatActivity {

    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TextView tvTitulo = findViewById(R.id.tvTitle);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvApellido = findViewById(R.id.tvApellido);
        TextView tvCiclo = findViewById(R.id.tvCiclo);
        TextView tvCurso = findViewById(R.id.tvCurso);
        */

        // rellenamos el arrayList con datos de prueba
        populateAlumnos();

        // enganchamos el recyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // construimos el adapter hecho por nosotros en una clase aparte, pasandole el arrayList
        AlumnoAdapter adapter = new AlumnoAdapter(listaAlumnos);

        // seteamos un layout al reciclerview (sino peta)
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // enganchamos el adapter con el recycerView
        recyclerView.setAdapter(adapter);

    }

    private void populateAlumnos() {

        Alumno a = new Alumno();

        a.setNombre("Iban");
        a.setApellido("Sauce");
        a.setCiclo("DAM");
        a.setCurso(2);

        listaAlumnos.add(a);

        for(int i = 0; i < 50; i++)
        {
            Alumno a1 = new Alumno();

            a1.setNombre("Alumno " + i);
            a1.setApellido("Apellido " + i);
            a1.setCiclo("DAM");
            a1.setCurso(1);

            listaAlumnos.add(a1);
        }

    }


}