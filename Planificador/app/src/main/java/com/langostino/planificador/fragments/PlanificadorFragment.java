package com.langostino.planificador.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.NuevoActivity;
import com.langostino.planificador.PlanificadorActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.adaptadores.ListaPlanesAdapter;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Planes;

import java.util.ArrayList;

public class PlanificadorFragment extends Fragment implements SearchView.OnQueryTextListener {

    android.widget.SearchView txtBuscar;
    FloatingActionButton fabCrear, fabHorario;
    RecyclerView lista;
    ArrayList<Planes> listaArrayPlanes;
    ListaPlanesAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlanificadorFragment() {
        // Required empty public constructor
    }

    public static PlanificadorFragment newInstance(String param1, String param2) {
        PlanificadorFragment fragment = new PlanificadorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_planificador, container, false);

        fabCrear = v.findViewById(R.id.fabCrear);
        fabHorario = v.findViewById(R.id.fabHorario);
        fabHorario.setVisibility(View.INVISIBLE);
        lista = v.findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(getContext()));

        DbPlanificador dbContactos = new DbPlanificador(getContext());

        listaArrayPlanes = new ArrayList<>();

        adapter = new ListaPlanesAdapter(dbContactos.mostrarPlanes());
        lista.setAdapter(adapter);

        fabCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoRegistro();
            }
        });

        //txtBuscar.setOnQueryTextListener((android.widget.SearchView.OnQueryTextListener) this);
        return v;
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(getContext(), NuevoActivity.class);
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