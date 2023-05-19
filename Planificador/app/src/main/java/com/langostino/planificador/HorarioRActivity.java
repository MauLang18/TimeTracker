package com.langostino.planificador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.adaptadores.ListaHorarioAdapter;
import com.langostino.planificador.adaptadores.ListaPlanesAdapter;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Horarios;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;

public class HorarioRActivity extends AppCompatActivity {

    SearchView txtBuscar;
    FloatingActionButton fabCrear, fabHorario;
    RecyclerView lista;
    ArrayList<Horarios> listaArrayPlanes;
    ListaHorarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_ractivity);
        fabHorario = findViewById(R.id.fabActividades);
        fabHorario.setVisibility(View.INVISIBLE);
        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));

        DbPlanificador dbContactos = new DbPlanificador(HorarioRActivity.this);

        listaArrayPlanes = new ArrayList<>();

        adapter = new ListaHorarioAdapter(dbContactos.mostrarHorario());
        lista.setAdapter(adapter);

        fabHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horario();
            }
        });
    }

    private void horario(){
        Intent intent = new Intent(this, ActividadesActivity.class);
        startActivity(intent);
    }

}