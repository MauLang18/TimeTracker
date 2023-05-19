package com.langostino.planificador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.adaptadores.ListaPlanesAdapter;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;

public class PlanificadorActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    SearchView txtBuscar;
    FloatingActionButton fabCrear, fabHorario;
    RecyclerView lista;
    ArrayList<Planes> listaArrayPlanes;
    ListaPlanesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificador);
        txtBuscar = findViewById(R.id.txtBuscar);
        fabCrear = findViewById(R.id.fabCrear);
        fabHorario = findViewById(R.id.fabHorario);
        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));

        DbPlanificador dbContactos = new DbPlanificador(PlanificadorActivity.this);

        listaArrayPlanes = new ArrayList<>();

        adapter = new ListaPlanesAdapter(dbContactos.mostrarPlanes());
        lista.setAdapter(adapter);

        fabCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoRegistro();
            }
        });

        fabHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horario();
            }
        });

        txtBuscar.setOnQueryTextListener(this);
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }

    private void horario(){
        Intent intent = new Intent(this, HorarioActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}