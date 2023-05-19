package com.langostino.planificador.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.langostino.planificador.ActividadesActivity;
import com.langostino.planificador.HorarioActivity;
import com.langostino.planificador.NuevoAActivity;
import com.langostino.planificador.R;
import com.langostino.planificador.adaptadores.ListaActividadesAdapter;
import com.langostino.planificador.db.DbPlanificador;
import com.langostino.planificador.entidades.Actividades;

import java.util.ArrayList;

public class ActividadesFragment extends Fragment {

    FloatingActionButton fabCrear, fabHorario;
    RecyclerView lista;
    ArrayList<Actividades> listaArrayPlanes;
    ListaActividadesAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActividadesFragment() {
        // Required empty public constructor
    }

    public static ActividadesFragment newInstance(String param1, String param2) {
        ActividadesFragment fragment = new ActividadesFragment();
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

        View v = inflater.inflate(R.layout.fragment_actividades, container, false);

        fabCrear = v.findViewById(R.id.fabCrear);
        fabHorario = v.findViewById(R.id.fabHorario);
        fabHorario.setVisibility(View.INVISIBLE);
        lista = v.findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(getContext()));

        DbPlanificador dbContactos = new DbPlanificador(getContext());

        listaArrayPlanes = new ArrayList<>();

        adapter = new ListaActividadesAdapter(dbContactos.mostrarActividades());
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

        return v;
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(getContext(), NuevoAActivity.class);
        startActivity(intent);
    }

    private void horario(){
        Intent intent = new Intent(getContext(), HorarioActivity.class);
        startActivity(intent);
    }
}